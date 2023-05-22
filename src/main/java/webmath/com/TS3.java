package webmath.com;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sources.Driver;
import sources.MathforEveryone;
import sources.Webmath;

public class TS3 {

	WebDriver driver;
	private String Url = Webmath.URL;

	@BeforeClass
	public void launch() {
		// Set up the WebDriver and open the browser
		System.setProperty("webdriver.chrome.driver",Driver.chromedriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);

	}
	
	@BeforeMethod
	public void ToMathForEveryone() {
	
		driver.manage(). timeouts(). implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(MathforEveryone.link)).click();	
		
	}
	
	@AfterMethod
	public void tomainframe() {
		driver.switchTo().defaultContent();
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void TC001() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Figuring a tip']")).click();
		String ttl = driver.getTitle();
		String expectedttl ="Tip Calculator - WebMath";
		Assert.assertEquals(ttl, expectedttl, "Test failed, Site is not redirected to tip calculator page");
	
	}
	
	@Test(priority = 2)
	public void TC002() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Figuring a tip']")).click();
		WebElement tippercent = driver.findElement(By.xpath("//input[@name='param0']"));
		WebElement mealcost = driver.findElement(By.xpath("//input[@name='param1']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(tippercent.isDisplayed(),"Test failed, Tip percentage input box is not displayed");
		Assert.assertTrue(mealcost.isDisplayed(),"Test failed, Meal cost input box is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Sybmit button is not displayed");
		
		Assert.assertTrue(tippercent.isEnabled(),"Test failed, Tip percentage input box is not enabled");
		Assert.assertTrue(mealcost.isEnabled(),"Test failed, Meal Cost input box is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority = 3)
	public void TC003() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Figuring a tip']")).click();
		driver.findElement(By.xpath("//input[@name='param0']")).clear();
		driver.findElement(By.xpath("//input[@name='param0']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@name='param1']")).sendKeys("100");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		WebElement calculationframe = driver.findElement(By.xpath("//iframe[@id='centerContentFrame']"));
		Assert.assertTrue(calculationframe.isDisplayed(),"Test failed, calculation not done");
		
		driver.switchTo().frame(calculationframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/font/blockquote[1]/center[2]/table/tbody/tr/td/font")).getText();
		String expectedresult = "$100.00 + $10.00 = $110.00.";
		
		Assert.assertEquals(result, expectedresult, "Test failed, calculation is not correct");
		
	}
	
	@Test(priority = 4)
	public void TC004() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Sale price']")).click();
		String ttl = driver.getTitle();
		String expectedttl ="Calculate the Sale Price of an Item on Sale - WebMath";
		Assert.assertEquals(ttl, expectedttl, "Test failed, Site is not redirected to Cost calculator page");
	
	}
	
	@Test(priority = 5)
	public void TC005() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Sale price']")).click();
		WebElement cost = driver.findElement(By.xpath("//input[@name='param0']"));
		WebElement offpercent = driver.findElement(By.xpath("//input[@name='param1']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(cost.isDisplayed(),"Test failed, Cost input box is not displayed");
		Assert.assertTrue(offpercent.isDisplayed(),"Test failed, Discount percentage input box is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Sybmit button is not displayed");
		
		Assert.assertTrue(cost.isEnabled(),"Test failed, Cost input box is not enabled");
		Assert.assertTrue(offpercent.isEnabled(),"Test failed, Discount percentage input box is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority = 6)
	public void TC006() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Sale price']")).click();
		driver.findElement(By.xpath("//input[@name='param0']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='param1']")).sendKeys("5");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		WebElement calculationframe = driver.findElement(By.xpath("//iframe[@id='centerContentFrame']"));
		Assert.assertTrue(calculationframe.isDisplayed(),"Test failed, calculation not done");
		
		driver.switchTo().frame(calculationframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/font/center[3]/table/tbody/tr/td")).getText();
		String expectedresult = "0.950 x $100 = $95.00.";
		
		Assert.assertEquals(result, expectedresult, "Test failed, calculation is not correct");
		
	}
	
	@Test(priority = 7)
	public void TC007() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Wind Chill']")).click();
		String ttl = driver.getTitle();
		String expectedttl ="Calculate Windchill Temperature - WebMath";
		Assert.assertEquals(ttl, expectedttl, "Test failed, Site is not redirected to windchill calculator page");
	
	}
	
	@Test(priority = 8)
	public void TC008() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Wind Chill']")).click();
		WebElement temp = driver.findElement(By.xpath("//input[@name='param0']"));
		WebElement windseed = driver.findElement(By.xpath("//input[@name='param1']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(temp.isDisplayed(),"Test failed, Temperature input box is not displayed");
		Assert.assertTrue(windseed.isDisplayed(),"Test failed, Wind speed percentage input box is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
		
		Assert.assertTrue(temp.isEnabled(),"Test failed, Temperature input box is not enabled");
		Assert.assertTrue(windseed.isEnabled(),"Test failed, Wind speed input box is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority = 9)
	public void TC009() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Wind Chill']")).click();
		driver.findElement(By.xpath("//input[@name='param0']")).sendKeys("82");
		driver.findElement(By.xpath("//input[@name='param1']")).sendKeys("15");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		WebElement calculationframe = driver.findElement(By.xpath("//iframe[@id='centerContentFrame']"));
		Assert.assertTrue(calculationframe.isDisplayed(),"Test failed, calculation not done");
		
		driver.switchTo().frame(calculationframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/font/center[2]/table/tbody/tr/td/center/font")).getText();
		String expectedresult = "59.50 ° F";
		
		Assert.assertEquals(result, expectedresult, "Test failed, calculation is not correct");
		
	}
	
	@Test(priority = 10)
	public void TC010() throws Exception {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Count Coins']")).click();
		String ttl = driver.getTitle();
		String expectedttl ="Help with Counting U.S. Coins - WebMath";
		Assert.assertEquals(ttl, expectedttl, "Test failed, Site is not redirected to windchill calculator page");
	
	}
	
	@Test(priority = 11)
	public void TC011() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Count Coins']")).click();
		WebElement quarters = driver.findElement(By.xpath("//input[@name='q']"));
		WebElement dimes = driver.findElement(By.xpath("//input[@name='d']"));
		WebElement nickels = driver.findElement(By.xpath("//input[@name='n']"));
		WebElement pennies = driver.findElement(By.xpath("//input[@name='p']"));
		
		
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(quarters.isDisplayed(),"Test failed, Quarters input box is not displayed");
		Assert.assertTrue(dimes.isDisplayed(),"Test failed, Dimes percentage input box is not displayed");
		Assert.assertTrue(nickels.isDisplayed(),"Test failed, Nickels percentage input box is not displayed");
		Assert.assertTrue(pennies.isDisplayed(),"Test failed, Pennies percentage input box is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
		
		Assert.assertTrue(quarters.isEnabled(),"Test failed, Quarters input box is not enabled");
		Assert.assertTrue(dimes.isEnabled(),"Test failed, Dimes input box is not enabled");
		Assert.assertTrue(nickels.isEnabled(),"Test failed, Nickels input box is not enabled");
		Assert.assertTrue(pennies.isEnabled(),"Test failed, Pennies speed input box is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	
	
	@Test(priority = 12)
	public void TC012() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Count Coins']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("8");
		driver.findElement(By.xpath("//input[@name='d']")).sendKeys("6");
		driver.findElement(By.xpath("//input[@name='n']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@name='p']")).sendKeys("2");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		WebElement calculationframe = driver.findElement(By.xpath("//iframe[@id='centerContentFrame']"));
		Assert.assertTrue(calculationframe.isDisplayed(),"Test failed, calculation not done");
		
		driver.switchTo().frame(calculationframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/blockquote/center/table/tbody/tr/td/font")).getText();
		String expectedresult = "Total=$2.82";
		
		Assert.assertEquals(result, expectedresult, "Test failed, calculation is not correct");
		
	}
	
	@Test(priority = 13)
	public void TC013()  {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Lottery Odds']")).click();
		String ttl = driver.getTitle();
		String expectedttl ="Calculate Your Chance of Winning the Lottery - WebMath";
		Assert.assertEquals(ttl, expectedttl, "Test failed, Site is not redirected to Lott winning chance calculator page");
	
	}
	
	@Test(priority = 14)
	public void TC014() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Lottery Odds']")).click();
		WebElement count = driver.findElement(By.xpath("//input[@name='count']"));
		WebElement low = driver.findElement(By.xpath("//input[@name='low']"));
		WebElement high = driver.findElement(By.xpath("//input[@name='high']"));		
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(count.isDisplayed(),"Test failed, Count input box is not displayed");
		Assert.assertTrue(low.isDisplayed(),"Test failed, Low input box is not displayed");
		Assert.assertTrue(high.isDisplayed(),"Test failed, High input box is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
		
		Assert.assertTrue(count.isEnabled(),"Test failed, Count input box is not enabled");
		Assert.assertTrue(low.isEnabled(),"Test failed, Low input box is not enabled");
		Assert.assertTrue(high.isEnabled(),"Test failed, High input box is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=15)
	public void TC015() {
		
		driver.findElement(By.xpath("//*[text()='Lottery Odds']")).click();
		driver.findElement(By.xpath("//input[@name='count']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@name='low']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@name='high']")).sendKeys("4");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		WebElement calculationframe = driver.findElement(By.xpath("//iframe[@id='centerContentFrame']"));
		Assert.assertTrue(calculationframe.isDisplayed(),"Test failed, calculation not done");
		
		driver.switchTo().frame(calculationframe);
		
		String result = driver.findElement(By.xpath("/html/body/font/blockquote/center/center/table/tbody/tr/td/font/center/p[1]/font")).getText();
		String expectedresult = "1 in 0";
		
		Assert.assertEquals(result, expectedresult, "Test failed, calculation is not correct");
		
	}

}
