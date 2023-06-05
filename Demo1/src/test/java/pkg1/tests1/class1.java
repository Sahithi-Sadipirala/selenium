package pkg1.tests1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class class1 {
    protected WebDriver driver;
    
	public WebDriver testcase_ppt()throws InterruptedException, IOException{
		System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
      	driver.get("https://microsoft.sharepoint-df.com/:p:/r/teams/PPTTCS/_layouts/15/Doc.aspx?sourcedoc=%7B779dd211-937d-4f05-9b54-ada97ac17c43%7D&action=edit&share=IQER0p13fZMFT5tUral6wXxDASdLaxJW6Be_s173-6kitNM");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = driver.getCurrentUrl();
		System.out.println(url);
	//	String pagesource = driver.getPageSource();
	//	System.out.println(pagesource);
		return driver;
	}
	
	public WebDriver testcase_dropdown()throws InterruptedException, IOException{
		System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		return driver;
	}
	
}
