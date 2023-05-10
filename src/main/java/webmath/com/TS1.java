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

public class TS1 {
	private WebDriver driver;
	private String Url = "https://www.webmath.com/";

	@BeforeClass
	public void launch() {
		// Set up the WebDriver and open the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sreen\\OneDrive\\\\Documents\\QA\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void close() {
		// Close the browser and quit the WebDriver
		driver.quit();
	}

	@Test(priority = 1)
	public void TC001() {
		// Step 1: Launch browser and navigate to URL
		driver.get(Url);

		// Step 2: Verify that the application is launched successfully
		String expectedTitle = "WebMath - Solve Your Math Problem";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Application is not launched successfully");
	}

	@Test(priority = 2)
	public void TC002() {
		// Step 1: Verify that the main navigation menu is displayed correctly
		WebElement navigationMenu = driver.findElement(By.xpath("//*[@id='d-navigationTop']"));
		Assert.assertTrue(navigationMenu.isDisplayed(), "Main navigation menu is not displayed correctly");
	}

	@Test(priority = 3)
	public void TC003() {
		// Step 1: Verify that the logo on the homepage is clickable and redirects to
		// the homepage
		WebElement logo = driver.findElement(By.xpath("//*[@alt='WebMath - Solve your math problem today']"));
		Assert.assertTrue(logo.isDisplayed(), "Logo on the homepage is not displayed");

		// Step 2: Click on the logo
		logo.click();

		// Step 3: Verify that the user is redirected to the homepage
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Url, "Clicking on the logo did not redirect to the homepage");
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
		WebElement homeButton = driver.findElement(By.xpath("//*[@title='WebMath Home Page']"));
		homeButton.click();
		String eURL = "https://www.webmath.com/index.html";

		// Step 2: Verify navigation
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, eURL, "Home button navigation is not working");
	}

	@Test(priority = 6)
	public void TC006() {
		// Step 1: Click on Contact Us
		WebElement contactUsLink = driver.findElement(By.xpath("//*[@title='Contact WebMath']"));
		contactUsLink.click();

		// Step 2: Verify redirection to the contact us page
		String expectedTitle = "Contact Information - WebMath";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Contact Us page is not displayed");

		// Step 3: Verify contact details

		WebElement contactinfo = driver.findElement(By.xpath("//*[text()='webmathadmin@gmail.com']"));
		Assert.assertTrue(contactinfo.isDisplayed(), "Test failed, contact information is not displayed");

	}

	@Test(priority = 7)
	public void TC007() {

		driver.findElement(By.xpath("//*[@title='About WebMath']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "What is WebMath? - WebMath";

		Assert.assertEquals(ttl, expectedttl, "Test failed, site not redirected to About WebMath");
		WebElement info = driver.findElement(By.xpath("(//*[@class='d-mainContainerRow'])[3]"));

		Assert.assertTrue(info.isDisplayed(), "Test failed, user is not able to see information about Webmath");

	}

	@Test(priority = 8)
	public void TC008() {

		driver.findElement(By.xpath("//*[@title='Why WebMath']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Why Webmath? - WebMath";

		Assert.assertEquals(ttl, expectedttl, "Test failed, site not redirected to Why WebMath");
		WebElement info = driver.findElement(By.xpath("//*[@id='d-childMainContLeft']"));

		Assert.assertTrue(info.isDisplayed(), "Test failed, user is not able to see uses and functions of WebMath");

	}

	@Test(priority = 9)
	public void TC009() {

		driver.findElement(By.xpath("//*[@title='Website Map Index']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Site Map - WebMath";

		Assert.assertEquals(ttl, expectedttl, "Test failed, site not redirected to Site Map");
		WebElement map = driver.findElement(By.xpath("//*[@id='d-childMainContLeft']"));

		Assert.assertTrue(map.isDisplayed(), "Test failed, user is not able to see Site Map of WebMath");

	}

	@Test(priority = 10)
	public void TC010() {

		driver.findElement(By.xpath("//*[@title='Privacy Policy']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Privacy Policy | Discovery Education";

		Assert.assertEquals(ttl, expectedttl, "Test failed, site not redirected to Privacy Policy");
		WebElement ppolicy = driver.findElement(By.xpath(
				"//*[@class='horizontal-cta-button comet-button comet-button--primary comet-button--small btn shadow-100']"));

		Assert.assertTrue(ppolicy.isDisplayed(), "Test failed, user is not able to see Privacy Policies");

	}

}
