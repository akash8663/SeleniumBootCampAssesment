package seleniumTaskTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import seleniumTask.AutomationHotel;

public class AutomationHotelTest {

	WebDriver driver;
	AutomationHotel hotel;
	String driverPathChrome = ".\\drivers\\chromedriver.exe";
	String driverPathFirefox = ".\\drivers\\geckodriver.exe";

	@BeforeTest
	@Parameters("browser")
	public void loadApp(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", driverPathFirefox);
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", driverPathChrome);
			// create chrome instance
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws InterruptedException {
		driver.get("https://www.hotels.com/");
		hotel = new AutomationHotel(driver);
		hotel.searchingHotel("New York");
	}

	@AfterTest
	public void exitingApp() {
		driver.close();
	}

}
