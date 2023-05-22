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

import sources.Driver;
import sources.MathforEveryone;
import sources.Webmath;

public class TS2 {

	WebDriver driver;
	private String Url = Webmath.URL;

	@BeforeClass
	public void launch() {
		// Set up the WebDriver and open the browser
		System.setProperty("webdriver.chrome.driver", Driver.chromedriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.findElement(By.xpath(MathforEveryone.link)).click();
	}

	@AfterClass
	public void close() {
		// Close the browser and quit the WebDriver
		driver.quit();
	}

	@Test(priority = 1)
	public void TC001() {

		String ttl = driver.getTitle();
		String expectedttl = MathforEveryone.ttl;
		Assert.assertEquals(ttl, expectedttl, "Test failed, site is not redirected to Math for everyone page");
	}

	@Test(priority = 2)
	public void TC002() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		Assert.assertEquals(links.size(), MathforEveryone.linkcount,
				"Test failed, total links in the page are not " + MathforEveryone.linkcount);

	}

	@Test(priority = 3)
	public void TC003() {

		WebElement tip = driver.findElement(By.xpath(MathforEveryone.tip));
		WebElement saleprice = driver.findElement(By.xpath(MathforEveryone.saleprice));
		WebElement windchill = driver.findElement(By.xpath(MathforEveryone.windchill));
		WebElement coincount = driver.findElement(By.xpath(MathforEveryone.coincount));
		WebElement lotteryOdds = driver.findElement(By.xpath(MathforEveryone.lottods));

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

		WebElement Length = driver.findElement(By.xpath(MathforEveryone.Length));
		WebElement mass = driver.findElement(By.xpath(MathforEveryone.mass));
		WebElement area = driver.findElement(By.xpath(MathforEveryone.area));
		WebElement volume = driver.findElement(By.xpath(MathforEveryone.volume));
		WebElement speed = driver.findElement(By.xpath(MathforEveryone.speed));
		WebElement power = driver.findElement(By.xpath(MathforEveryone.power));
		WebElement Temps = driver.findElement(By.xpath(MathforEveryone.temp));

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

		WebElement SimpleInterest = driver.findElement(By.xpath(MathforEveryone.sampleinterest));
		WebElement CompoundInterest = driver.findElement(By.xpath(MathforEveryone.compoundinterest));
		WebElement Retirement = driver.findElement(By.xpath(MathforEveryone.retirement));
		WebElement loan = driver.findElement(By.xpath(MathforEveryone.loan));

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

		WebElement Costofelectricity = driver.findElement(By.xpath(MathforEveryone.costofelectricity));

		Assert.assertTrue(Costofelectricity.isDisplayed(), "Test failed, Cost of electricity link is not displayed");

		Assert.assertTrue(Costofelectricity.isEnabled(), "Test failed, Cost of electricity link is not Enabled");

	}

	@Test(priority = 7)
	public void TC007() {

		WebElement WeightonAnotherPlanet = driver.findElement(By.xpath(MathforEveryone.weightonplanet));

		Assert.assertTrue(WeightonAnotherPlanet.isDisplayed(),
				"Test failed, Weight on Another Planet link is not displayed");

		Assert.assertTrue(WeightonAnotherPlanet.isEnabled(),
				"Test failed, Weight on Another Planet link is not Enabled");

	}

	@Test(priority = 8)
	public void TC008() {
		driver.findElement(By.xpath(MathforEveryone.instructionlink)).click();
		String ttl = driver.getTitle();
		String expectedttl = MathforEveryone.instructionsttl;
		Assert.assertEquals(ttl, expectedttl, "Test failed, site is not redirected to instructions page");
		WebElement instructions = driver.findElement(By.xpath(MathforEveryone.instructionslist));
		Assert.assertTrue(instructions.isDisplayed(),
				"Test failed, user is not able to see the instructions to write problem");

	}

}
