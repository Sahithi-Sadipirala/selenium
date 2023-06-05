package demo1;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver.*;
public class java1 {
	static WebDriver driver;
    public static void open_url(){
   	 System.setProperty("webdriver.edge.driver", "C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
   	 driver = new EdgeDriver();	
   	 driver.get("https://microsoft.sharepoint-df.com/:p:/r/teams/PPTTCS/_layouts/15/Doc.aspx?sourcedoc=%7B54D4D20A-3DDA-48AE-948A-52A408E82703%7D&file=Presentation1.pptx&action=edit&mobileredirect=true&share=IQEK0tRU2j2uSJSKUqQI6CcDASni_nPk7tlllOqV03UAFyE");
   	 driver.manage().window().maximize();
    }
    public static void design() throws InterruptedException {
    	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	Thread.sleep(5000);
    	driver.switchTo().frame("wac_frame");
    	driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//*[text()='Click to add text']")).click();
    	driver.findElement(By.xpath("//div[@id='WACViewPanel_EditingElement']/child::*[1]")).sendKeys("cat");
    	Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='Design']")).click();
        driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-DesignerNew']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@aria-label='Design idea 1']")).click();
        WebElement tc = driver.findElement(By.xpath("//*[@d='M0 0 L732 0 L732 93 L0 93 Z']"));
        System.out.println(tc);
        if(tc.isDisplayed()) {
        	System.out.println("Testcase failed");
        }
        else {
        	System.out.println("Testcase passed");
        }      
    	}
      //driver.switchTo().defaultContent();
       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // WebElement element1 = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-type='RibbonToggleButton']")));
       // element1.click();
	public static void main(String[] args) throws InterruptedException {
		open_url();
        design();
	}
}
