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

import com.PageObjectClasses.HomePage;

import reusableMethods.ReusableMethods;
import sources.Driver;
import sources.Homepage;
import sources.Webmath;

public class TS1_Homepage {
	private WebDriver driver;
	ReusableMethods m = new ReusableMethods();

	@BeforeClass
	public void launch() {
		// Set up the WebDriver and open the browser
		System.setProperty("webdriver.chrome.driver",Driver.chromedriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void close() {
		// Close the browser and quit the WebDriver
		driver.quit();
	}

	@Test(priority = 1)
	public void TC001() throws Exception {
		// Step 1: Launch browser and navigate to URL
		driver.get(Webmath.URL);

		// Step 2: Verify that the application is launched successfully
		String expectedTitle = Webmath.title;
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Application is not launched successfully");
	}

	@Test(priority = 2)
	public void TC002() {
		// Step 1: Verify that the main navigation menu is displayed correctly
		WebElement navigationMenu = driver.findElement(HomePage.navigationmenu);
		Assert.assertTrue(navigationMenu.isDisplayed(), "Main navigation menu is not displayed correctly");
	}

	@Test(priority = 3)
	public void TC003() {
		// Step 1: Verify that the logo on the homepage is clickable and redirects to
		// the homepage
		WebElement logo = driver.findElement((HomePage.logo));
		Assert.assertTrue(logo.isDisplayed(), "Logo on the homepage is not displayed");

		// Step 2: Click on the logo
		logo.click();

		// Step 3: Verify that the user is redirected to the homepage
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Webmath.URL, "Clicking on the logo did not redirect to the homepage");
	}

	@Test(priority = 4)
	public void TC004() {
		// Step 1: Verify that all links are visible and working
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			Assert.assertTrue(link.isDisplayed(), "Link is not visible");
			Assert.assertTrue(link.isEnabled(), "Link is not clickable");
		}
	}

	@Test(priority = 5)
	public void TC005() {
		// Step 1: Click on the home button
		WebElement homeButton = driver.findElement(HomePage.homebutton);
		homeButton.click();
		String URL = Homepage.homeurl;

		// Step 2: Verify navigation
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, URL, "Home button navigation is not working");
	}

	@Test(priority = 6)
	public void TC006() {
		// Step 1: Click on Contact Us
		WebElement contactUsLink = driver.findElement(HomePage.contactuslink);
		contactUsLink.click();

		// Step 2: Verify redirection to the contact us page
		String expectedTitle = Homepage.contactusttl;
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Contact Us page is not displayed");

		// Step 3: Verify contact details

		WebElement contactinfo = driver.findElement(HomePage.contactinfo);
		Assert.assertTrue(contactinfo.isDisplayed(), "Test failed, contact information is not displayed");

	}

	@Test(priority = 7)
	public void TC007() {

		driver.findElement(HomePage.aboutus).click();
		String ttl = driver.getTitle();
		String expectedttl = Homepage.aboutusttl;

		Assert.assertEquals(ttl, expectedttl, "Test failed, site not redirected to About WebMath");
		WebElement info = driver.findElement(HomePage.aboutusinfo);

		Assert.assertTrue(info.isDisplayed(), "Test failed, user is not able to see information about Webmath");

	}

	@Test(priority = 8)
	public void TC008() {

		driver.findElement(HomePage.why).click();
		String ttl = driver.getTitle();
		String expectedttl = Homepage.whyttl;

		Assert.assertEquals(ttl, expectedttl, "Test failed, site not redirected to Why WebMath");
		WebElement info = driver.findElement(HomePage.whywebmath);

		Assert.assertTrue(info.isDisplayed(), "Test failed, user is not able to see uses and functions of WebMath");

	}

	@Test(priority = 9)
	public void TC009() throws Exception {

		driver.findElement(HomePage.sitemaplink).click();
		String ttl = driver.getTitle();
		String expectedttl = Homepage.sitemapttl;

		Assert.assertEquals(ttl, expectedttl, "Test failed, site not redirected to Site Map");
		WebElement map = driver.findElement(HomePage.sitemapinfo);

		Assert.assertTrue(map.isDisplayed(), "Test failed, user is not able to see Site Map of WebMath");
		
	}

	@Test(priority = 10)
	public void TC010() {

		driver.findElement(HomePage.pplink).click();
		String ttl = driver.getTitle();
		String expectedttl = Homepage.ppttl;

		Assert.assertEquals(ttl, expectedttl, "Test failed, site not redirected to Privacy Policy");
		WebElement ppolicy = driver.findElement(HomePage.ppinfo);

		Assert.assertTrue(ppolicy.isDisplayed(), "Test failed, user is not able to see Privacy Policies");

	}

}
