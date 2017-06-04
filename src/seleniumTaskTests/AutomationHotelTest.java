package seleniumTaskTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import seleniumTask.AutomationHotel;

public class AutomationHotelTest {
	
	WebDriver driver;
	AutomationHotel hotel;
	String driverPath = "D:\\SeleniumProjects\\WebDriver\\chromedriver_win32\\chromedriver.exe";
	
	@BeforeTest
	public void loadApp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		
		driver.get("https://www.hotels.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void testApp() {
		hotel = new AutomationHotel(driver);
		hotel.searchingHotel("New York");
	}
	
	

	 
	
	

}
