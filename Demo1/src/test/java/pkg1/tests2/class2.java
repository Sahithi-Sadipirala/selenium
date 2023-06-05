package pkg1.tests2;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.Keys;
import java.util.List;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;
import pkg1.tests1.*;

 public class class2 extends class1 {
	 
	@Test
	public void testcase1_ppt_slides()throws InterruptedException, IOException{
	driver = testcase_ppt();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.switchTo().frame("wac_frame");	
//	driver.switchTo().frame("WacFrame_PowerPoint_0");	
//	driver.findElement(By.xpath("//*[@class='o365cs-base']"));
	Thread.sleep(3000);
	WebElement p = driver.findElement(By.id("meInitialsButton"));
	Actions builder = new Actions(driver);
	Action event1 = builder.moveToElement(p).build();
	event1.perform();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@data-unique-id='SingleLineRibbon-RibbonModeToggle']")).click();
	driver.findElement(By.name("Always Show")).click();
	WebDriverWait wait1 = new WebDriverWait(driver,30);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']"))).click();
	
	WebElement x = driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']"));
	if(x.isSelected()) {
		x.click();
	}
	String tagname = driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']")).getTagName();
	System.out.println(tagname);
	Thread.sleep(5000);
	WebElement t = driver.findElement(By.xpath("//input[@id='TellMe-SearchBox']"));
	if(t.isEnabled()) {
		t.sendKeys("shape");
	}
	do{
		System.out.println("searched shape");
		break;
	}while(t.isDisplayed());
	Thread.sleep(3000);
	t.clear();
	}
	
	@Test(dataProvider="getData")
	public void testcase2_ppt_actions(String search, String searchstatus) throws InterruptedException, IOException{
		Thread.sleep(3000);
		WebElement m=driver.findElement(By.xpath("//div[@title='Slide 1, Slide 1 of 2']"));
		WebElement n=driver.findElement(By.xpath("//div[@title='Slide 2, Slide 2 of 2']"));
		WebElement t = driver.findElement(By.xpath("//input[@id='TellMe-SearchBox']"));
		WebElement x = driver.findElement(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']"));
		Actions builder = new Actions(driver);
		Action event1 = builder.dragAndDrop(n, m).build();
		event1.perform();  
		Action event2 = builder.moveToElement(t).click().keyDown(Keys.SHIFT).sendKeys(t,search).keyUp(Keys.SHIFT).doubleClick().build();
		event2.perform();
		System.out.println(searchstatus);
		Thread.sleep(5000);
		Action event3 = builder.moveToElement(m).contextClick().build();
		event3.perform();
		Action event4 = builder.clickAndHold().moveToElement(x).release().build();
		event4.perform();
		String tooltip = x.getAttribute("aria-label");
		System.out.println(tooltip);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		data[0][0]="add-in";
		data[0][1]="searched add-in";
		data[1][0]="picture";
		data[1][1]="searched picture";
		data[2][0]="icon";
		data[2][1]="searched icon";
		return data;
	}
}