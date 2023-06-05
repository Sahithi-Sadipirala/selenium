package pkg1.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class class4 {
	static WebDriver driver;
	public class4(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(xpath="//button[@data-unique-id='StatusBar-ZoomIn']")
	WebElement zoom_in;
	
	@FindBy(id="TellMe-SearchBox")
	WebElement searchbox;
	
	public void scroll() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("WacFrame_PowerPoint_0");
		for(int i=0; i<5; i++) {
			zoom_in.click();
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('#ShowHideNotes').scrollDown=5000");
	}
	
	public void screenshot()throws InterruptedException, IOException{
		Thread.sleep(5000);	
	// Taking Full Page screenshot
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\v-ssahithi\\OneDrive - Microsoft\\Pictures\\Screenshot_slide.png"));
		// Taking screenshot of webelement(searchbox)	
				File src1 = searchbox.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src1,new File("C:\\Users\\v-ssahithi\\OneDrive - Microsoft\\Pictures\\Screenshot_searchbox.png"));
			// Getting Dimensions of webelement(zoomicon)
				System.out.println(searchbox.getRect().getDimension().getHeight());
				System.out.println(searchbox.getRect().getDimension().getWidth());
				driver.quit();
	}
}

