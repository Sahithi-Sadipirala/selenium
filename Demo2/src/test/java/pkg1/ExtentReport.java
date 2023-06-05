package pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.IOException;
import pkg1.test.class2;
import pkg1.test.class3;
import pkg1.test.class4;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {
	
	static WebDriver driver = null;
	
	public static void main(String[] args)throws InterruptedException, IOException {
	
		ExtentSparkReporter reporter = new ExtentSparkReporter("extentReports.html");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		
		ExtentTest test1 = extent.createTest("Test1","Sample Demo");
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
	 
		test1.log(Status.INFO, "Starting Test Case");
		class2 obj1 = new class2(driver); 
	    obj1.Goto();
	    test1.pass("Navigated to presentation");
	    obj1.ppt_slides();
	    test1.pass("Slide is added");
	    obj1.ppt_actions();
	    test1.pass("Performed actions on slides");
	    class3 obj2 = new class3(driver);
	    obj2.search_icons();
	    test1.pass("Searched Icons");
	    obj2.icons_size();
	    test1.pass("Provided Icons count");
	    class4 obj3 = new class4(driver);
	    obj3.scroll();
	    test1.pass("Page is scrolled");
	    obj3.screenshot();
	    test1.pass("Captured screenshot");
	    driver.close();
	    driver.quit();
	    test1.pass("Closed the browser");
	    test1.info("Test Completed");
	    extent.flush();
	}

}
