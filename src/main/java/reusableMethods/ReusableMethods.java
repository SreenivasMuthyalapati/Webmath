package reusableMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ReusableMethods {
	
	
	public WebDriver driver; 

    public void Navigation(String ttl, String Expectedttl) {
        Assert.assertEquals(ttl, Expectedttl, "Test Failed, driver is not redirected to the expected page");
    }

    public void Validation(WebElement w) {
        Assert.assertTrue(w.isDisplayed(), w + " is not displayed");
        Assert.assertTrue(w.isEnabled(), w + " is not enabled");
    }
    
    public void Calculation(WebElement result) {
    	Assert.assertTrue(result.isDisplayed(), "Test failed, calculation not done");
    	
    }

    public void CalculationAccuracy(String result, String expectedresult) {
        
        Assert.assertEquals(result, expectedresult, "Test failed, calculation is not correct");
    }

    public void Launch(String Url) {
        // Set up the WebDriver and open the browser
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Sreen\\OneDrive\\\\Documents\\QA\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
    }

    public void close(WebDriver driver) {
        driver.close();
    }

    public void Switchtodefaultframe(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
	
	
}
