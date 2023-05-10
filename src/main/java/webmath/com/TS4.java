package webmath.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS4 {
	
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

	}
	
	@BeforeMethod
	public void ToMathForEveryone() {
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@title='Math for Everyone']")).click();	
		
	}
	
	@AfterMethod
	public void tomainframe() {
		driver.switchTo().defaultContent();
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@Test(priority=1, description = "Verify that the driver is being redirected to Length converter page")
	public void TC001() {
		
		driver.findElement(By.xpath("//*[text()='Length']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Lengths - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=2)
	public void TC002() {
		
		driver.findElement(By.xpath("//*[text()='Length']")).click();
		WebElement lngth = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(lngth.isDisplayed(),"Test failed, length input box is not displayed");
		Assert.assertTrue(units.isDisplayed(),"Test failed, Units dropdown is not displayed");
		Assert.assertTrue(tounit.isDisplayed(),"Test failed, Units to be converted dropdown is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
	
		Assert.assertTrue(lngth.isEnabled(),"Test failed, length input box is not enabled");
		Assert.assertTrue(units.isEnabled(),"Test failed, Units dropdown box is not enabled");
		Assert.assertTrue(tounit.isEnabled(),"Test failed,  Units to be converted dropdown is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=3)
	public void TC003() {
		
		driver.findElement(By.xpath("//*[text()='Length']")).click();
		WebElement lngth = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		lngth.sendKeys("12");
		Select s = new Select(units);
		s.selectByVisibleText("inch(es)");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("centimeter(s)");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 12 inch(es) is 30.480000 centimeter(s)";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=4)
	public void TC004() {
		
		driver.findElement(By.xpath("//*[text()='mass']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Masses - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=5)
	public void TC005() {
		
		driver.findElement(By.xpath("//*[text()='mass']")).click();
		WebElement mass = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(mass.isDisplayed(),"Test failed, mass input box is not displayed");
		Assert.assertTrue(units.isDisplayed(),"Test failed, Units dropdown is not displayed");
		Assert.assertTrue(tounit.isDisplayed(),"Test failed, Units to be converted dropdown is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
	
		Assert.assertTrue(mass.isEnabled(),"Test failed, mass input box is not enabled");
		Assert.assertTrue(units.isEnabled(),"Test failed, Units dropdown box is not enabled");
		Assert.assertTrue(tounit.isEnabled(),"Test failed,  Units to be converted dropdown is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=6)
	public void TC006() {
		
		driver.findElement(By.xpath("//*[text()='mass']")).click();
		WebElement mass = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		mass.sendKeys("1000");
		Select s = new Select(units);
		s.selectByVisibleText("gram(s)");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("kilogram(s)");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 1000 gram(s) is 1.000000 kilogram(s)";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=7)
	public void TC007() {
		
		driver.findElement(By.xpath("//*[text()='area']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Areas - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=8)
	public void TC008() {
		
		driver.findElement(By.xpath("//*[text()='area']")).click();
		WebElement area = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(area.isDisplayed(),"Test failed, area input box is not displayed");
		Assert.assertTrue(units.isDisplayed(),"Test failed, Units dropdown is not displayed");
		Assert.assertTrue(tounit.isDisplayed(),"Test failed, Units to be converted dropdown is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
	
		Assert.assertTrue(area.isEnabled(),"Test failed, area input box is not enabled");
		Assert.assertTrue(units.isEnabled(),"Test failed, Units dropdown box is not enabled");
		Assert.assertTrue(tounit.isEnabled(),"Test failed,  Units to be converted dropdown is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=9)
	public void TC009() {
		
		driver.findElement(By.xpath("//*[text()='area']")).click();
		WebElement area = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		area.sendKeys("1000");
		Select s = new Select(units);
		s.selectByVisibleText("square foot/feet");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("square meter(s)");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 1000 square foot/feet is 92.936806 square meter(s)";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=10)
	public void TC010() {
		
		driver.findElement(By.xpath("//*[text()='volume']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Volumes - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=11)
	public void TC011() {
		
		driver.findElement(By.xpath("//*[text()='volume']")).click();
		WebElement vol = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(vol.isDisplayed(),"Test failed, Volume input box is not displayed");
		Assert.assertTrue(units.isDisplayed(),"Test failed, Units dropdown is not displayed");
		Assert.assertTrue(tounit.isDisplayed(),"Test failed, Units to be converted dropdown is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
	
		Assert.assertTrue(vol.isEnabled(),"Test failed, Volume input box is not enabled");
		Assert.assertTrue(units.isEnabled(),"Test failed, Units dropdown box is not enabled");
		Assert.assertTrue(tounit.isEnabled(),"Test failed,  Units to be converted dropdown is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=12)
	public void TC012() {
		
		driver.findElement(By.xpath("//*[text()='volume']")).click();
		WebElement vol = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		vol.sendKeys("100");
		Select s = new Select(units);
		s.selectByVisibleText("cup(s)");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("liter(s)");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 100 cup(s) is 23.687500 liter(s)";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=13)
	public void TC013() {
		
		driver.findElement(By.xpath("//*[text()='speed']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Speed - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=14)
	public void TC014() {
		
		driver.findElement(By.xpath("//*[text()='speed']")).click();
		WebElement spd = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(spd.isDisplayed(),"Test failed, Speed input box is not displayed");
		Assert.assertTrue(units.isDisplayed(),"Test failed, Units dropdown is not displayed");
		Assert.assertTrue(tounit.isDisplayed(),"Test failed, Units to be converted dropdown is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
	
		Assert.assertTrue(spd.isEnabled(),"Test failed, Speed input box is not enabled");
		Assert.assertTrue(units.isEnabled(),"Test failed, Units dropdown box is not enabled");
		Assert.assertTrue(tounit.isEnabled(),"Test failed,  Units to be converted dropdown is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=15)
	public void TC015() {
		
		driver.findElement(By.xpath("//*[text()='speed']")).click();
		WebElement spd = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		spd.sendKeys("60");
		Select s = new Select(units);
		s.selectByVisibleText("kilometer(s) per hour");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("mile(s) per hour");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 60 kilometer(s) per hour is 37.267082 mile(s) per hour";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=16)
	public void TC016() {
		
		driver.findElement(By.xpath("//*[text()='power']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Power - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=17)
	public void TC017() {
		
		driver.findElement(By.xpath("//*[text()='power']")).click();
		WebElement pwr = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(pwr.isDisplayed(),"Test failed, Power input box is not displayed");
		Assert.assertTrue(units.isDisplayed(),"Test failed, Units dropdown is not displayed");
		Assert.assertTrue(tounit.isDisplayed(),"Test failed, Units to be converted dropdown is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
	
		Assert.assertTrue(pwr.isEnabled(),"Test failed, Power input box is not enabled");
		Assert.assertTrue(units.isEnabled(),"Test failed, Units dropdown box is not enabled");
		Assert.assertTrue(tounit.isEnabled(),"Test failed,  Units to be converted dropdown is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=18)
	public void TC018() {
		
		driver.findElement(By.xpath("//*[text()='power']")).click();
		WebElement spd = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		spd.sendKeys("100");
		Select s = new Select(units);
		s.selectByVisibleText("horsepower");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("watt(s)");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 100 horsepower is 74600.000000 watt(s)";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=19)
	public void TC019() {
		
		driver.findElement(By.xpath("//*[text()='Temps.']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Convert temperature Scales - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=20)
	public void TC020() {
		
		driver.findElement(By.xpath("//*[text()='Temps.']")).click();
		WebElement temp = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(temp.isDisplayed(),"Test failed, Temperature input box is not displayed");
		Assert.assertTrue(units.isDisplayed(),"Test failed, Units dropdown is not displayed");
		Assert.assertTrue(tounit.isDisplayed(),"Test failed, Units to be converted dropdown is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
	
		Assert.assertTrue(temp.isEnabled(),"Test failed, Temperature input box is not enabled");
		Assert.assertTrue(units.isEnabled(),"Test failed, Units dropdown box is not enabled");
		Assert.assertTrue(tounit.isEnabled(),"Test failed,  Units to be converted dropdown is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=21)
	public void TC021() {
		
		driver.findElement(By.xpath("//*[text()='Temps.']")).click();
		WebElement temp = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		temp.sendKeys("95");
		Select s = new Select(units);
		s.selectByVisibleText("° F");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("° C");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/center[2]/table/tbody/tr/td/font")).getText();
		String expectedresult = "95 ° F is 35.00 ° C.";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	
	
	
	
	
	
	

}
	
	
