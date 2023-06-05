package pkg1.tests2;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pkg1.tests1.*;

public class class4 extends class1 {
	static WebDriver driver;
    @Parameters({"http://google.com"})
	@Test
	public static void testcase7_alert(@Optional("http://google.com") String url)throws InterruptedException{
 	    System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com");
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("text");
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
    	driver.switchTo().alert().dismiss();
    	driver.quit();
    }
  
	@Test
   public static void windowhandle_testcase8()throws InterruptedException{
 	System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
		driver.quit();
 }
 
 @Test(dependsOnMethods= {"windowhandle_testcase8"})
 public static void countlinksbywindowhandle_testcase9()throws InterruptedException{
 	System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
     System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//3-
		WebElement coloumndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		
		//4- click on each link in the coloumn and check if the pages are opening-
		for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
		{
			
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
			
		}// opens all the tabs
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext())
		{
			
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		
		}
		driver.quit();
 }

}
