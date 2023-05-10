package webmath.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TS2 {

	WebDriver driver;
	private String Url = "https://www.webmath.com/";

	@BeforeClass
	public void launch() {
		// Set up the WebDriver and open the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sreen\\OneDrive\\\\Documents\\QA\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.findElement(By.xpath("//*[@title='Math for Everyone']")).click();
	}

	@AfterClass
	public void close() {
		// Close the browser and quit the WebDriver
		driver.quit();
	}

	@Test(priority = 1)
	public void TC001() {

		String ttl = driver.getTitle();
		String expectedttl = "Math for Everyone - WebMath";
		Assert.assertEquals(ttl, expectedttl, "Test failed, site is not redirected to Math for everyone page");
	}

	@Test(priority = 2)
	public void TC002() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		Assert.assertEquals(links.size(), 36, "Test failed, total links in the page are not 36");

	}

	@Test(priority = 3)
	public void TC003() {

		WebElement tip = driver.findElement(By.xpath("//a[text()='Figuring a tip']"));
		WebElement saleprice = driver.findElement(By.xpath("//a[text()='Sale price']"));
		WebElement windchill = driver.findElement(By.xpath("//a[text()='Wind Chill']"));
		WebElement coincount = driver.findElement(By.xpath("//a[text()='Count Coins']"));
		WebElement lotteryOdds = driver.findElement(By.xpath("//a[text()='Lottery Odds']"));

		Assert.assertTrue(tip.isDisplayed(), "Test failed, Figuring tip link is not displayed");
		Assert.assertTrue(saleprice.isDisplayed(), "Test failed, Sale Price link is not displayed");
		Assert.assertTrue(windchill.isDisplayed(), "Test failed, Wind chill link is not displayed");
		Assert.assertTrue(coincount.isDisplayed(), "Test failed, Coin count link is not displayed");
		Assert.assertTrue(lotteryOdds.isDisplayed(), "Test failed, Lottery Odds link is not displayed");

		Assert.assertTrue(tip.isEnabled(), "Test failed, Figuring tip link is not Enabled");
		Assert.assertTrue(saleprice.isEnabled(), "Test failed, Sale Price link is not Enabled");
		Assert.assertTrue(windchill.isEnabled(), "Test failed, Wind chill link is not Enabled");
		Assert.assertTrue(coincount.isEnabled(), "Test failed, Coin count link is not Enabled");
		Assert.assertTrue(lotteryOdds.isEnabled(), "Test failed, Lottery Odds link is not Enabled");

	}

	@Test(priority = 4)
	public void TC004() {

		WebElement Length = driver.findElement(By.xpath("//a[text()='Length']"));
		WebElement mass = driver.findElement(By.xpath("//a[text()='mass']"));
		WebElement area = driver.findElement(By.xpath("//a[text()='area']"));
		WebElement volume = driver.findElement(By.xpath("//a[text()='volume']"));
		WebElement speed = driver.findElement(By.xpath("//a[text()='speed']"));
		WebElement power = driver.findElement(By.xpath("//a[text()='power']"));
		WebElement Temps = driver.findElement(By.xpath("//a[text()='Temps.']"));

		Assert.assertTrue(Length.isDisplayed(), "Test failed, Length converter link is not displayed");
		Assert.assertTrue(mass.isDisplayed(), "Test failed, Mass converter link is not displayed");
		Assert.assertTrue(area.isDisplayed(), "Test failed, Area converter link is not displayed");
		Assert.assertTrue(volume.isDisplayed(), "Test failed, Volume converter link is not displayed");
		Assert.assertTrue(speed.isDisplayed(), "Test failed, speed converter is not displayed");
		Assert.assertTrue(power.isDisplayed(), "Test failed, Power converter link is not displayed");
		Assert.assertTrue(Temps.isDisplayed(), "Test failed, Temperature converter link is not displayed");

		Assert.assertTrue(Length.isEnabled(), "Test failed, Length converter link is not Enabled");
		Assert.assertTrue(mass.isEnabled(), "Test failed, Mass converter link is not Enabled");
		Assert.assertTrue(area.isEnabled(), "Test failed, Area converter link is not Enabled");
		Assert.assertTrue(volume.isEnabled(), "Test failed, Volume converter link is not Enabled");
		Assert.assertTrue(speed.isEnabled(), "Test failed, speed converter link is not Enabled");
		Assert.assertTrue(power.isEnabled(), "Test failed, Power converter link is not Enabled");
		Assert.assertTrue(Temps.isEnabled(), "Test failed, Temperature converter link is not Enabled");
	}

	@Test(priority = 5)
	public void TC005() {

		WebElement SimpleInterest = driver.findElement(By.xpath("//a[text()='Simple Interest']"));
		WebElement CompoundInterest = driver.findElement(By.xpath("//a[text()='Compound Interest']"));
		WebElement Retirement = driver.findElement(By.xpath("//a[text()='Retirement']"));
		WebElement loan = driver.findElement(By.xpath("//a[text()='A loan']"));

		Assert.assertTrue(SimpleInterest.isDisplayed(), "Test failed, Simple Interest link is not displayed");
		Assert.assertTrue(CompoundInterest.isDisplayed(), "Test failed, Compound Interest link is not displayed");
		Assert.assertTrue(Retirement.isDisplayed(), "Test failed, Retirement link is not displayed");
		Assert.assertTrue(loan.isDisplayed(), "Test failed, loan link is not displayed");

		Assert.assertTrue(SimpleInterest.isEnabled(), "Test failed, Simple Interest link is not Enabled");
		Assert.assertTrue(CompoundInterest.isEnabled(), "Test failed, Compound Interest link is not Enabled");
		Assert.assertTrue(Retirement.isEnabled(), "Test failed, Retirement link is not Enabled");
		Assert.assertTrue(loan.isEnabled(), "Test failed, loan link is not Enabled");

	}

	@Test(priority = 6)
	public void TC006() {

		WebElement Costofelectricity = driver.findElement(By.xpath("//a[text()='Cost of electricity']"));

		Assert.assertTrue(Costofelectricity.isDisplayed(), "Test failed, Cost of electricity link is not displayed");

		Assert.assertTrue(Costofelectricity.isEnabled(), "Test failed, Cost of electricity link is not Enabled");

	}

	@Test(priority = 7)
	public void TC007() {

		WebElement WeightonAnotherPlanet = driver.findElement(By.xpath("//a[text()='Weight on Another Planet?']"));

		Assert.assertTrue(WeightonAnotherPlanet.isDisplayed(),"Test failed, Weight on Another Planet link is not displayed");

		Assert.assertTrue(WeightonAnotherPlanet.isEnabled(),"Test failed, Weight on Another Planet link is not Enabled");

	}

	@Test(priority = 8)
	public void TC008() {
		driver.findElement(By.xpath("//a[@title='Help typing in your problem']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Typing Math Problems into this Site - WebMath";
		Assert.assertEquals(ttl, expectedttl, "Test failed, site is not redirected to instructions page");
		WebElement instructions = driver.findElement(By.xpath("//*[@id='d-childMainContLeft']"));
		Assert.assertTrue(instructions.isDisplayed(),"Test failed, user is not able to see the instructions to write problem");

	}

}
