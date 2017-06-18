package seleniumTask;

import static org.testng.Assert.assertEquals;

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
	DateFormat dateFormat = new SimpleDateFormat("LL/dd/yy");

	public AutomationHotel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q-destination")
	WebElement destinationName;
	@FindBy(css = "div.autosuggest-category-result")
	WebElement autosuggesion;

	public void enterDestinationName(String location) throws InterruptedException {
		System.out.println("putting location");
		destinationName.clear();
		destinationName.sendKeys(location);
		Thread.sleep(2000);
		autosuggesion.click();

	}

	@FindBy(name = "q-localised-check-in")
	WebElement checkInDate;

	public void enterCheckInDate() throws InterruptedException {
		System.out.println("checkin date");
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		checkInDate.clear();
		// Thread.sleep(2000);
		checkInDate.sendKeys(dateFormat.format(tomorrow));
		System.out.println(dateFormat.format(tomorrow));

	}

	@FindBy(name = "q-localised-check-out")
	WebElement checkOutDate;

	public void enterCheckOutDate() throws InterruptedException {
		System.out.println("checkout date");
		calendar.add(Calendar.DAY_OF_YEAR, 5);
		Date after5Days = calendar.getTime();
		checkOutDate.clear();
		// Thread.sleep(2000);
		checkOutDate.sendKeys(dateFormat.format(after5Days));
		System.out.println(dateFormat.format(after5Days));
	}

	// @FindBy(xpath = "//button[@class='cta cta-strong']")
	@FindBy(css = "button.cta.cta-strong")
	WebElement searchBtn;

	public void clickSearchBtn() throws InterruptedException {
		System.out.println("clicking submit");
		Thread.sleep(2000);
		if (searchBtn.isDisplayed()) {
			searchBtn.submit();
		} else {
			System.out.println("button not enable");
		}
		// checkOutDate.submit();
	}

	// @FindBy(xpath = "//*[@class='summary']//*[text()='New York, New York,
	// United States Of America']")
	@FindBy(xpath = "//div[@class = 'summary']//h1")
	WebElement verifyPage;

	public void verifyNewPage() throws InterruptedException {
		System.out.println("Navigating to next page");
		Thread.sleep(5000);
		System.out.println("Actual = " + verifyPage.getText());
		assertEquals(verifyPage.getText(), "New York, New York, United States Of America");
		// assertTrue(verifyPage.getText().equals("New York, New York, United
		// States Of America"));
	}

	public void searchingHotel(String location) throws InterruptedException {
		this.enterDestinationName(location);
		this.enterCheckInDate();
		this.enterCheckOutDate();
		this.clickSearchBtn();
		this.verifyNewPage();
	}
}
