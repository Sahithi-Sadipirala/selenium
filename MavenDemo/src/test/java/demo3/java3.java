package demo3;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver.*;
public class java3 {
	static WebDriver driver;
    public static void open_url(){
   	 System.setProperty("webdriver.edge.driver", "C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
   	 driver = new EdgeDriver();
   	 driver.get("https://microsoft.sharepoint-df.com/:p:/r/teams/PPTTCS/_layouts/15/Doc.aspx?sourcedoc=%7B54D4D20A-3DDA-48AE-948A-52A408E82703%7D&file=Presentation1.pptx&action=edit&mobileredirect=true&share=IQEK0tRU2j2uSJSKUqQI6CcDASni_nPk7tlllOqV03UAFyE");
   	 driver.manage().window().maximize();
    }
    public static void design() throws InterruptedException {
    	Thread.sleep(5000);
    	driver.switchTo().frame("WacFrame_PowerPoint_0");
    	//Thread.sleep(5000);
    	//driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']")).click();
    	//Thread.sleep(5000);
    	//driver.findElement(By.xpath("//span[text()='Click to add text']")).click();
    	//driver.findElement(By.xpath("//div[@id='WACViewPanel_EditingElement']/child::*[1]")).sendKeys("cat");
        Thread.sleep(5000);
    	WebElement m=driver.findElement(By.xpath("//img[@title='Slide 1']"));
        WebElement n=driver.findElement(By.xpath("//img[@title='Slide 2']"));
        Actions act1 = new Actions(driver);
        act1.dragAndDrop(n, m).build().perform();  
    	}
	public static void main(String[] args) throws InterruptedException {
		open_url();
        design(); 
	}
}
