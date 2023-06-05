package seven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class scrolling {
static WebDriver driver;
public static void scroll()throws IOException{
	System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	driver  = new EdgeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.manage().window().maximize();
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
//	js.executeScript("document.querySelector('.tableFixHead').scrollLeft=5000");
	
	List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	try {
	int sum=0;
	for(int i=0; i<values.size();i++) {
		sum = sum + Integer.parseInt(values.get(i).getText());
	}
	System.out.println(sum);
	int total = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
	Assert.assertEquals(sum,total);
	}
	catch(NumberFormatException e) {
		System.out.println(e.toString());
	}
	}
public static void screenshot()throws IOException{
	System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	driver  = new EdgeDriver();
	driver.get("http://www.google.com");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
// Taking Full Page screenshot
	File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File("C:\\Users\\v-ssahithi\\OneDrive - Microsoft\\Pictures\\Screenshot_google.png"));
	WebElement searchbox = driver.findElement(By.className("gLFyf"));
	searchbox.click();
	searchbox.sendKeys("sahithi");
// Taking screenshot of webelement(searchbox)	
	File src1 = searchbox.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src1,new File("C:\\Users\\v-ssahithi\\OneDrive - Microsoft\\Pictures\\Screenshot_searchbox.png"));
// Getting Dimensions of webelement(searchbox)
	System.out.println(searchbox.getRect().getDimension().getHeight());
	System.out.println(searchbox.getRect().getDimension().getWidth());
		
}

public static void main(String[] args)throws IOException{
	scroll();
	screenshot();
}
}
