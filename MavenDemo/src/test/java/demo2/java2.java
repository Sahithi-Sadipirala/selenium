package demo2;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver.*;
public class java2 {
	static WebDriver driver;
    public static void open_url(){
   	 System.setProperty("webdriver.edge.driver", "C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
   	 driver = new EdgeDriver();
   	 driver.get("https://microsoft.sharepoint-df.com/:p:/r/teams/PPTTCS/_layouts/15/Doc.aspx?sourcedoc=%7B54D4D20A-3DDA-48AE-948A-52A408E82703%7D&file=Presentation1.pptx&action=edit&mobileredirect=true&share=IQEK0tRU2j2uSJSKUqQI6CcDASni_nPk7tlllOqV03UAFyE");
   	 driver.manage().window().maximize();
    }
    public static void scenario4() throws InterruptedException {
    	//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	Thread.sleep(5000);
    	driver.switchTo().frame("wac_frame");
       // driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']")).click();
         driver.findElement(By.xpath("//button[@id='Insert']")).click();
    	 Thread.sleep(5000);
    	 for(int i=0;i<3;i++) {
         driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-InsertSlideSplit']")).click();
         Thread.sleep(2000);}
         Thread.sleep(3000);
         driver.findElement(By.xpath("//button[@aria-label='Pictures']")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("//button[@name='Stock Images...']")).click();
         Thread.sleep(7000);
         driver.switchTo().frame("InsertMediaFrame");
         driver.findElement(By.xpath("//div[@class='ms-List-surface']/child::*[1]/child::*[1]/child::*[1]/child::*[1]")).click();
         driver.findElement(By.xpath("//button[@class='ms-Button ms-Button--primary footer_action_button_9e5083b2 footer_action_button footer_insert_button_9e5083b2 root-207']")).click();
         Thread.sleep(5000);
         driver.switchTo().frame("wac_frame");
         driver.findElement(By.xpath("//button[@id='SlideShow']")).click();
         driver.findElement(By.xpath("//button[@id='PlayFromCurrentSlide']")).click();
         Thread.sleep(5000);
         driver.switchTo().frame("SlideShowHostFrame");
         WebElement frame=driver.findElement(By.xpath("//iframe[@allow='autoplay;']"));
         driver.switchTo().frame(frame);
         WebElement tc = driver.findElement(By.xpath("//div[@class='InkCanvasContainer']"));
         System.out.println(tc);
         if(tc.isDisplayed()) {
         	System.out.println("Testcase passed");
         }
         else {
         	System.out.println("Testcase failed");
         }
    	//WebDriverWait wait = new WebDriverWait(driver, 20);
        // WebElement element1 = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-unique-id='FarPeripheralControls-PresentDropDown']")));       
        //element1.click();
        }
    public static void main(String[] args) throws InterruptedException {
		open_url();
        scenario4();
	}  

}
