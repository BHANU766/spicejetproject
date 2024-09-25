package sjpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidatefieldsPage {

	By checkinButton = By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'][normalize-space()='check-in']");
	By flightstatusButton = By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'][normalize-space()='flight status']");
	By managebookingButton = By.xpath("//div[contains(text(),'manage booking')]");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ValidatefieldsPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		//wait = new WebDriverWait(driver, 10);
	}
	
	public void clickCheckin() {
		driver.findElement(checkinButton).click();
	}
	
	public void clickFlightstatus() {
		driver.findElement(flightstatusButton).click();
	}
	
	public void clickManagebooking() {
		driver.findElement(managebookingButton).click();
	}
}
