package one;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class class1 {
static WebDriver driver;
public static void open_url()throws InterruptedException {
System.setProperty("webdriver.edge.driver", "C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");	
driver = new EdgeDriver();
driver.get("https://microsoft.sharepoint-df.com/:p:/r/teams/PPTTCS/_layouts/15/Doc.aspx?sourcedoc=%7BBEE2565B-DCB5-4C8B-8DBE-CC9166BF3FF6%7D&file=Presentation3.pptx&action=edit&mobileredirect=true&share=IQFbVuK-tdyLTI2-zJFmvz_2AXoi2sbk4RyLPzoTcUO1RN4");
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
String url = driver.getCurrentUrl();
System.out.println(url);
String pagesource = driver.getPageSource();
System.out.println(pagesource);

driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

Thread.sleep(5000);
driver.switchTo().frame("WacFrame_PowerPoint_0");
Thread.sleep(5000);

WebDriverWait wait1 = new WebDriverWait(driver,30);
wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']")));

WebElement x = driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']"));
if(x.isSelected()) {
	x.click();
}
String tagname = driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']")).getTagName();
System.out.println(tagname);
Thread.sleep(5000);
WebElement t = driver.findElement(By.xpath("//input[@id='TellMe-SearchBox']"));
if(t.isEnabled()) {
	t.sendKeys("sahithi");
}
do{
	System.out.println("Hi sahithi");
	break;
}while(t.isDisplayed());
Thread.sleep(3000);
t.clear();
//driver.findElement(By.xpath("//input[@id='TellMe-SearchBox']")).sendKeys("sahithi");

String expectedtitle = "Presentation3.pptx";
String actualtitle = "";
actualtitle = driver.getTitle();
if(actualtitle.contentEquals(expectedtitle)) {
System.out.println("Testcase passed");
}
else {
	System.out.println("Testcase failed");
}

List <WebElement> count = driver.findElements(By.xpath("//span[text()='Click to add title']"));
System.out.println("Count of the element is:"+count.size());

//driver.findElement(By.id("Insert")).click();
//Thread.sleep(5000);
//Select slides = new Select(driver.findElement(By.id("InsertPicturesFlyout")));
//slides.selectByVisibleText("Stock Images...");
//slides.selectByIndex(0);
//driver.findElement(By.xpath("//button[@aria-label='New Slide Show More Options']")).click();
//Thread.sleep(5000);
//Select slides = new Select(driver.findElement(By.xpath("//button[@aria-label='New Slide Show More Options']")));
//slides.selectByVisibleText("Section Header");

//String msg="";
//msg = driver.switchTo().alert().getText();
//System.out.println(msg);
//driver.switchTo().alert().sendKeys("sahithi");
//driver.switchTo().alert().accept();
//driver.switchTo().alert().dismiss();

//driver.close();
//driver.quit();
}
public static void main(String[] args)throws InterruptedException{
	open_url();
}
}
