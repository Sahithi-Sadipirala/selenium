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
import org.openqa.selenium.support.ui.WebDriverWait;

public class class3 {
	 static WebDriver driver;
		public class3(WebDriver driver) {
			super();
			this.driver = driver;
			PageFactory.initElements(driver,this);		
		}
		
		@FindBy(id="TellMe-SearchBox")
		WebElement searchbox;
		
		@FindBy(name="Icons")
		WebElement icon_option;
		
		@FindBy(id="Icons_Abacus")
		List<WebElement> icons;
		
		@FindBy(xpath="//i[@class='header_close_icon-122']")
		WebElement closewindow;
		
		@FindBy(xpath="//div[@id='Icons_Acorn']")
		WebElement icon;

		@FindBy(xpath="//span[@id='id__28']//parent::*[1]//parent::*[1]//parent::*[1]")
		WebElement insert;

		
		 public void search_icons() throws InterruptedException {
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   Thread.sleep(3000);
		//	   driver.switchTo().frame("WacFrame_PowerPoint_0");
			   searchbox.sendKeys("icons");
			   WebDriverWait wait2 = new WebDriverWait(driver,30);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("Icons"))).click();
		   }
		   public void icons_size() {
			   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   driver.switchTo().frame("insertmediaframe");
			   System.out.println(icons.size());
			   icon.click();
			   insert.click();
			   
			//   closewindow.click();
		   }
  
}
