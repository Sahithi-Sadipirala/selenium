package pkg1.test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class class2{
    WebDriver driver;
	public class2(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}

	
	@FindBy(id="meInitialsButton")
	WebElement p;
	
	@FindBy(xpath="//button[@data-unique-id='SingleLineRibbon-RibbonModeToggle']")
	WebElement ribbon_displayoptions;
	
	@FindBy(name="Always Show")
	WebElement alwaysshowribbon;
	
	@FindBy(xpath="//button[@data-unique-id='Ribbon-NewSlideSplit']")
	WebElement x;
	
	@FindBy(xpath="//div[@title='Slide 1, Slide 1 of 2']//img")
	WebElement m;
	
	@FindBy(xpath="//div[@title='Slide 2, Slide 2 of 2']//img")
	WebElement n;
	
	@FindBy(id="TellMe-SearchBox")
	WebElement t;
	
	public void Goto(){
		driver.get("https://microsoft.sharepoint-df.com/:p:/r/teams/PPTTCS/_layouts/15/Doc.aspx?sourcedoc=%7B779dd211-937d-4f05-9b54-ada97ac17c43%7D&action=edit&share=IQER0p13fZMFT5tUral6wXxDASdLaxJW6Be_s173-6kitNM");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	public void ppt_slides()throws InterruptedException, IOException{
		Thread.sleep(5000);
//		driver.switchTo().frame("wac_frame");	
		driver.switchTo().frame("WacFrame_PowerPoint_0");			
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		Action event1 = builder.moveToElement(p).build();
		event1.perform();
		Thread.sleep(5000);
		ribbon_displayoptions.click();
		alwaysshowribbon.click();
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-unique-id='Ribbon-NewSlideSplit']"))).click();
		
		if(x.isSelected()) {
			x.click();
		}
		}
	
	public void ppt_actions() throws InterruptedException, IOException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		Action event1 = builder.dragAndDrop(n, m).build();
		event1.perform();  
		Thread.sleep(3000);
		Action event2 = builder.moveToElement(t).click().keyDown(Keys.SHIFT).sendKeys(t,"picture").keyUp(Keys.SHIFT).doubleClick().build();
		event2.perform();
		System.out.println("searched pictures");
		Thread.sleep(5000);
	//	Action event3 = builder.moveToElement(m).contextClick().build();
	//	event3.perform();
	//	Action event4 = builder.clickAndHold().moveToElement(x).release().build();
	//	event4.perform();
	//	String tooltip = x.getAttribute("aria-label");
	//	System.out.println(tooltip);
	}  
  
}
