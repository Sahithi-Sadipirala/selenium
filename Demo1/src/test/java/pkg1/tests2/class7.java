package pkg1.tests2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class class7 {

	@Test(enabled=false)
	public static void testcase13_brokenlinks(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
	    
        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a =new SoftAssert();
        for(WebElement link : links) {
                String url= link.getAttribute("href");
                HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
		          conn.setRequestMethod("HEAD");
		          conn.connect();
		          int respCode = conn.getResponseCode();
		          System.out.println(respCode);
		          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
		      }
		      a.assertAll();
		      driver.quit();
 }
}
