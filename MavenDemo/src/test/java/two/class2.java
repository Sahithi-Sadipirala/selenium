package two;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class class2{
static WebDriver driver;
public static void open_url()throws InterruptedException{
System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
driver = new EdgeDriver();
driver.get("https://microsoft.sharepoint-df.com/:p:/r/teams/PPTTCS/_layouts/15/Doc.aspx?sourcedoc=%7BBEE2565B-DCB5-4C8B-8DBE-CC9166BF3FF6%7D&file=Presentation3.pptx&action=edit&mobileredirect=true&share=IQFbVuK-tdyLTI2-zJFmvz_2AXoi2sbk4RyLPzoTcUO1RN4");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.switchTo().frame("WacFrame_PowerPoint_0");

//WebDriverWait wait1 = new WebDriverWait(driver,30);
//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Slide 1']")));

Thread.sleep(5000);
WebElement m=driver.findElement(By.xpath("//img[@title='Slide 1']"));
WebElement n=driver.findElement(By.xpath("//img[@title='Slide 2']"));
WebElement t = driver.findElement(By.xpath("//input[@id='TellMe-SearchBox']"));
WebElement x = driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']"));
Actions builder = new Actions(driver);
Action event1 = builder.dragAndDrop(n, m).build();
event1.perform();  
Action event2 = builder.moveToElement(t).click().keyDown(Keys.SHIFT).sendKeys(t,"sahithi").keyUp(Keys.SHIFT).doubleClick().build();
event2.perform();
Thread.sleep(5000);
Action event3 = builder.moveToElement(m).contextClick().build();
event3.perform();
Action event4 = builder.clickAndHold().moveToElement(x).release().build();
event4.perform();
String tooltip = x.getAttribute("aria-label");
System.out.println(tooltip);

}
public static void main(String[] args)throws InterruptedException{
open_url();	
}
}