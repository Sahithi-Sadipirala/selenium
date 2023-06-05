package six;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class class6 {
	static WebDriver driver;
	public static void assignment6()throws InterruptedException{
		System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption2")).click();
		String checkbox_text = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(checkbox_text);
		Select drop =new Select(driver.findElement(By.id("dropdown-class-example")));
		drop.selectByVisibleText(checkbox_text);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkbox_text);
		driver.findElement(By.id("alertbtn")).click();
		String alert_text = driver.switchTo().alert().getText();
		String a = alert_text.split(",")[0];
		String b = a.split(" ")[1];
		Assert.assertEquals(b, checkbox_text);
		if(b.contains(checkbox_text)) {
			System.out.println("Success");
			}
		else
			System.out.println("Fail");
	}
	
	public static void assignment7()throws InterruptedException{
		System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		WebElement table = driver.findElement(By.name("courses"));
		System.out.println(table.findElements(By.cssSelector(".table-display td:nth-child(3)")).size());
		System.out.println(table.findElements(By.cssSelector(".table-display tr th")).size());
        for(int i=0; i<table.findElements(By.cssSelector(".table-display tr th")).size(); i++) {
		System.out.println(table.findElements(By.cssSelector(".table-display tr:nth-child(3) td")).get(i).getText());}
	}
	
	public static void assignment8()throws InterruptedException{
		System.setProperty("webdriver.edge.driver","C:\\Users\\v-ssahithi\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
	}
	
	public static void main(String[] args)throws InterruptedException {
		assignment6();
		assignment7();
		assignment8();
	}

}
