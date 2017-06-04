package seleniumTask;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationHotel {

	WebDriver driver;
	Calendar calendar = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd-LL-yyyy");
	
	@FindBy(name = "q-destination")
	WebElement destinationName;
	
	@FindBy(name = "q-localised-check-in")
	WebElement checkInDate;
	
	@FindBy(name = "q-localised-check-out")
	WebElement checkOutDate;
	
	@FindBy(xpath = "//button[@class='cta cta-strong']")
	WebElement searchBtn;
	
	public AutomationHotel (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterDestinationName(String location) {
		destinationName.sendKeys(location);
		destinationName.submit();
	}
	public void enterCheckInDate() {
		
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		checkInDate.sendKeys(dateFormat.format(tomorrow));
		//System.out.println(dateFormat.format(tomorrow));
	}
	public void enterCheckOutDate() {
		
		calendar.add(Calendar.DAY_OF_YEAR, 5);
		Date after5Days = calendar.getTime();
		checkOutDate.sendKeys(dateFormat.format(after5Days));
		//System.out.println(dateFormat.format(after5Days));
	}
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void searchingHotel(String location) {
		this.enterDestinationName(location);
		this.enterCheckInDate();
		this.enterCheckOutDate();
		this.clickSearchBtn();
	}
}
