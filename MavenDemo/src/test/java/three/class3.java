package three;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Alert;
import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.WindowType;

import java.util.Set;
import java.util.Iterator;

public class class3 {
       static WebDriver driver;
       public static void openurl()throws InterruptedException{
    	   System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
   		driver = new EdgeDriver();
   		driver.get("http://google.com");
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
       }
     
    public static void windowhandle()throws InterruptedException{
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
    }
    
    public static void countlinksbywindowhandle()throws InterruptedException{
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
    }

 public static void invoke_multiplewindows_or_tabs()throws InterruptedException{
	 System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	 driver = new EdgeDriver();
     driver.get("https://rahulshettyacademy.com/angularpractice/");

	 //Switching to new Tab
	 driver.switchTo().newWindow(WindowType.TAB);
	 
	// Switching to new Window
	 driver.switchTo().newWindow(WindowType.WINDOW);
	 
     Set<String> handles=driver.getWindowHandles();
	 Iterator<String> it=handles.iterator();
	 String parentWindowId = it.next();
	 String childWindow =it.next();
	 driver.switchTo().window(childWindow);
	 driver.get("https://rahulshettyacademy.com/");
	 String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
	 driver.switchTo().window(parentWindowId);
	 WebElement name=driver.findElement(By.cssSelector("[name='name']"));
     name.sendKeys(courseName); 
     
 }
	public static void main(String[] args)throws InterruptedException{
	    openurl();
		windowhandle();	
		countlinksbywindowhandle();
	//	invoke_multiplewindows_or_tabs();
	}

}
