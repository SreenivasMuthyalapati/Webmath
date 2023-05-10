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

public class TS5 {

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
		driver.findElement(By.xpath("//*[text()='Simple Interest']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Simple Interest Calculator - WebMath";
		rm.Navigation(ttl, expectedttl);
	}

	@Test(priority = 2)
	public void TC002() {
		driver.findElement(By.xpath("//*[text()='Simple Interest']")).click();
		WebElement principal = driver.findElement(By.xpath("//*[@name='principal']"));
		WebElement interest = driver.findElement(By.xpath("//*[@name='interest']"));
		WebElement period = driver.findElement(By.xpath("//*[@name='interest_units']"));
		WebElement desiredtime = driver.findElement(By.xpath("//*[@name='desired_time']"));
		WebElement desiredtimeunits = driver.findElement(By.xpath("//*[@name='desired_time_units']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		rm.Validation(principal);
		rm.Validation(interest);
		rm.Validation(period);
		rm.Validation(desiredtime);
		rm.Validation(desiredtimeunits);
		rm.Validation(submit);
	}

	@Test(priority = 3)
	public void TC003() {
		driver.findElement(By.xpath("//*[text()='Simple Interest']")).click();
		WebElement principal = driver.findElement(By.xpath("//*[@name='principal']"));
		WebElement interest = driver.findElement(By.xpath("//*[@name='interest']"));
		WebElement period = driver.findElement(By.xpath("//*[@name='interest_units']"));
		WebElement desiredtime = driver.findElement(By.xpath("//*[@name='desired_time']"));
		WebElement desiredtimeunits = driver.findElement(By.xpath("//*[@name='desired_time_units']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		principal.sendKeys("100000");
		interest.sendKeys("2");
		Select s = new Select(period);
		s.selectByVisibleText("Month");
		desiredtime.sendKeys("5");
		Select s1 = new Select(desiredtimeunits);
		s1.selectByIndex(0);
		submit.click();

		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		rm.Calculation(resultframe);
		driver.switchTo().frame(resultframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/blockquote/center[2]/table/tbody/tr/td/font")).getText();
		String expectedresult = "The interest is: $120000.00";
		rm.CalculationAccuracy(result, expectedresult);

	}
	
	@Test(priority = 4)
	public void TC004() {
		driver.findElement(By.xpath("//*[text()='Compound Interest']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Compound Interest Calculator - WebMath";
		rm.Navigation(ttl, expectedttl);
	}

	@Test(priority = 5)
	public void TC005() {
		driver.findElement(By.xpath("//*[text()='Compound Interest']")).click();
		WebElement principal = driver.findElement(By.xpath("//*[@name='principal']"));
		WebElement interest = driver.findElement(By.xpath("//*[@name='interest']"));
		WebElement compound = driver.findElement(By.xpath("//*[@name='compound']"));
		WebElement desiredtime = driver.findElement(By.xpath("//*[@name='desired_time']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		rm.Validation(principal);
		rm.Validation(interest);
		rm.Validation(compound);
		rm.Validation(desiredtime);
		rm.Validation(submit);
	}

	@Test(priority = 6)
	public void TC006() {
		driver.findElement(By.xpath("//*[text()='Compound Interest']")).click();
		WebElement principal = driver.findElement(By.xpath("//*[@name='principal']"));
		WebElement interest = driver.findElement(By.xpath("//*[@name='interest']"));
		WebElement compound = driver.findElement(By.xpath("//*[@name='compound']"));
		WebElement desiredtime = driver.findElement(By.xpath("//*[@name='desired_time']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		principal.sendKeys("100000");
		interest.sendKeys("20");
		compound.sendKeys("4");
		desiredtime.sendKeys("5");
		submit.click();

		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		rm.Calculation(resultframe);
		driver.switchTo().frame(resultframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/blockquote/blockquote[2]/center[4]/table/tbody/tr/td/font")).getText();
		String expectedresult = "$100000.00 × (1+0.05)20=$265329.77";
		rm.CalculationAccuracy(result, expectedresult);

	}
	
	@Test(priority = 7)
	public void TC007() {
		driver.findElement(By.xpath("//*[text()='Retirement']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Retirement Investment Calculator - WebMath";
		rm.Navigation(ttl, expectedttl);
	}

	@Test(priority = 8)
	public void TC008() {
		driver.findElement(By.xpath("//*[text()='Retirement']")).click();
		WebElement salary = driver.findElement(By.xpath("//*[@name='salary']"));
		WebElement initsavings = driver.findElement(By.xpath("//*[@name='start']"));
		WebElement contribution = driver.findElement(By.xpath("//*[@name='contrib']"));
		WebElement raiseofsalary = driver.findElement(By.xpath("//*[@name='raise']"));
		WebElement retrn = driver.findElement(By.xpath("//*[@name='return']"));
		WebElement years = driver.findElement(By.xpath("//*[@name='years']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		rm.Validation(salary);
		rm.Validation(initsavings);
		rm.Validation(contribution);
		rm.Validation(raiseofsalary);
		rm.Validation(retrn);
		rm.Validation(years);
		rm.Validation(submit);
	}

	@Test(priority = 9)
	public void TC009() {
		driver.findElement(By.xpath("//*[text()='Retirement']")).click();
		WebElement salary = driver.findElement(By.xpath("//*[@name='salary']"));
		WebElement initsavings = driver.findElement(By.xpath("//*[@name='start']"));
		WebElement contribution = driver.findElement(By.xpath("//*[@name='contrib']"));
		WebElement raiseofsalary = driver.findElement(By.xpath("//*[@name='raise']"));
		WebElement retrn = driver.findElement(By.xpath("//*[@name='return']"));
		WebElement years = driver.findElement(By.xpath("//*[@name='years']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		salary.sendKeys("10000");
		initsavings.sendKeys("0");
		contribution.sendKeys("10");
		raiseofsalary.sendKeys("10");
		retrn.sendKeys("12");
		years.sendKeys("30");
		submit.click();

		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		rm.Calculation(resultframe);
		driver.switchTo().frame(resultframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/blockquote/blockquote/p[4]/table/tbody/tr[31]/td/center/font/p[1]")).getText();
		String expectedresult = "$700589.12";
		rm.CalculationAccuracy(result, expectedresult);
		
		

	}
	
	@Test(priority = 10)
	public void TC010() {
		driver.findElement(By.xpath("//*[text()='A loan']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Amortization Schedule for a Loan - WebMath";
		rm.Navigation(ttl, expectedttl);
	}

	@Test(priority = 11)
	public void TC011() {
		driver.findElement(By.xpath("//*[text()='A loan']")).click();
		WebElement amount = driver.findElement(By.xpath("//*[@name='amount']"));
		WebElement years = driver.findElement(By.xpath("//*[@name='years']"));
		WebElement period = driver.findElement(By.xpath("//*[@name='period']"));
		WebElement rate = driver.findElement(By.xpath("//*[@name='rate']"));
		WebElement extra = driver.findElement(By.xpath("//*[@name='extra']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));

		rm.Validation(amount);
		rm.Validation(years);
		rm.Validation(period);
		rm.Validation(rate);
		rm.Validation(extra);
		rm.Validation(submit);
	}

	@Test(priority = 12)
	public void TC012() {
		driver.findElement(By.xpath("//*[text()='A loan']")).click();
		WebElement amount = driver.findElement(By.xpath("//*[@name='amount']"));
		WebElement years = driver.findElement(By.xpath("//*[@name='years']"));
		WebElement period = driver.findElement(By.xpath("//*[@name='period']"));
		WebElement rate = driver.findElement(By.xpath("//*[@name='rate']"));
		WebElement extra = driver.findElement(By.xpath("//*[@name='extra']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		amount.sendKeys("100000");
		years.sendKeys("10");
		period.sendKeys("12");
		rate.sendKeys("9");
		extra.sendKeys("0");
		submit.click();

		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		rm.Calculation(resultframe);
		driver.switchTo().frame(resultframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/ul/li[2]/font/blockquote")).getText();
		String expectedresult = "the loan + bank's profit = $100000.00 + $52010.95 = $152010.94.";
		rm.CalculationAccuracy(result, expectedresult);
		
		

	}
	
}
