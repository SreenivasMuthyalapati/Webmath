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

public class TS6_MathAtHome {
	
	WebDriver driver;
	public String Url = "https://www.webmath.com/";
	ReusableMethods rm = new ReusableMethods();

	@BeforeClass
	public void launch() {
		// Set up the WebDriver and open the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sreen\\OneDrive\\\\Documents\\QA\\Selenium\\chromedriver_win32\\chromedriver.exe");
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
		driver.findElement(By.xpath("//*[text()='Cost of electricity']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Calculate the Costs to Use Electricity - WebMath";
		rm.Navigation(ttl, expectedttl);
	}

	@Test(priority = 2)
	public void TC002() {
		driver.findElement(By.xpath("//*[text()='Cost of electricity']")).click();
		WebElement watts = driver.findElement(By.xpath("//*[@name='watts']"));
		WebElement time = driver.findElement(By.xpath("//*[@name='time']"));
		WebElement timeunit = driver.findElement(By.xpath("//*[@name='tunit']"));
		WebElement cost = driver.findElement(By.xpath("//*[@name='cost']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		rm.Validation(watts);
		rm.Validation(time);
		rm.Validation(timeunit);
		rm.Validation(cost);
		rm.Validation(submit);
	}

	@Test(priority = 3)
	public void TC003() {
		driver.findElement(By.xpath("//*[text()='Cost of electricity']")).click();
		WebElement watts = driver.findElement(By.xpath("//*[@name='watts']"));
		WebElement time = driver.findElement(By.xpath("//*[@name='time']"));
		WebElement timeunit = driver.findElement(By.xpath("//*[@name='tunit']"));
		WebElement cost = driver.findElement(By.xpath("//*[@name='cost']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		watts.sendKeys("580,1200,120,150");
		time.sendKeys("5");
		Select s = new Select(timeunit);
		s.selectByIndex(0);
		cost.sendKeys("0.10");
		submit.click();

		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		rm.Calculation(resultframe);
		driver.switchTo().frame(resultframe);
		
		String result = driver.findElement(By.xpath("/html/body/blockquote/font/center[3]/table/tbody/tr/td/font")).getText();
		String expectedresult = "10.25 kWh × $0.05f/kWh = $0.51";
		rm.CalculationAccuracy(result, expectedresult);

	}

}
