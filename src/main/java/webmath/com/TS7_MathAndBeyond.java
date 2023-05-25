package webmath.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import reusableMethods.ReusableMethods;

public class TS7_MathAndBeyond {
	
	WebDriver driver;
	public String Url = "https://www.webmath.com/";
	ReusableMethods rm = new ReusableMethods();

	@BeforeClass
	public void launch() {
		// Set up the WebDriver and open the browser
		
		 System.setProperty("webdriver.chrome.driver",
	                "C:\\Users\\Sreen\\OneDrive\\Documents\\QA\\Selenium\\chromedriver_win32\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get(Url);
	}

	@BeforeMethod
	public void tomathforeveryone() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement mathForEveryoneLink = driver.findElement(By.xpath("//a[@title='Math for Everyone']"));
		mathForEveryoneLink.click();
	}

	@AfterClass
	public void close() {
		rm.close(driver);
	}

	@AfterMethod
	public void todefaultframe() {
		rm.Switchtodefaultframe(driver);
	}

	@Test(priority = 1)
	public void TC001() {
		driver.findElement(By.xpath("//*[text()='Weight on Another Planet?']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Calculate Weight on Another Planet - WebMath";
		rm.Navigation(ttl, expectedttl);
	}

	@Test(priority = 2)
	public void TC002() {
		driver.findElement(By.xpath("//*[text()='Weight on Another Planet?']")).click();
		WebElement weight = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement planet = driver.findElement(By.xpath("//*[@name='param1']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		rm.Validation(weight);
		rm.Validation(planet);
		rm.Validation(submit);
	}

	@Test(priority = 3)
	public void TC003() {
		driver.findElement(By.xpath("//*[text()='Weight on Another Planet?']")).click();
		WebElement weight = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement planet = driver.findElement(By.xpath("//*[@name='param1']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		weight.sendKeys("143");
		Select s = new Select(planet);
		s.selectByIndex(4);
		submit.click();

		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		rm.Calculation(resultframe);
		driver.switchTo().frame(resultframe);
		
		String result = driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr/td/font/center/font")).getText();
		String expectedresult = "334.62 pounds!";
		rm.CalculationAccuracy(result, expectedresult);

	}

}
