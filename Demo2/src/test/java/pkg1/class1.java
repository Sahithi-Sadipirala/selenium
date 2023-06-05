package pkg1;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pkg1.test.class2;
import pkg1.test.class3;
import pkg1.test.class4;

public class class1{
		
protected WebDriver driver;

public static void main(String args[])throws InterruptedException, IOException {
	System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
    class2 obj1 = new class2(driver); 
    obj1.Goto();
    obj1.ppt_slides();
    obj1.ppt_actions();
    class3 obj2 = new class3(driver);
    obj2.search_icons();
    obj2.icons_size();
    class4 obj3 = new class4(driver);
    obj3.scroll();
    obj3.screenshot();
}
}
