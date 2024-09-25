   package sjtests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sjpages.BasePage;

public class OnewayroundTripFlightBookingTest extends BasePage {

//	login->flight finder->select flight->book flight->flight confirmation->logout		

	@Test(priority = 1)
	public void LogIn() {
		By loginButton = By.xpath("//div[text()='Login']");
		By mobilenumberField = By.xpath("//input[@type='number']");
		By passwordField = By.xpath("//input[@type='password']");
		By loginBtn = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[3]");

		driver.findElement(loginButton).click();
		wait(4000);

		driver.findElement(mobilenumberField).sendKeys("9440422243");
		driver.findElement(passwordField).sendKeys("Admin@123");
		wait(500);
		driver.findElement(loginBtn).click();
		wait(6000);

	}

	@Test(priority = 2)
	public void FlightFinder() {

		By FlightOption = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[1]/div[2]");
		By OneWayRB = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[1]");
//		By RoundtipRB = By.xpath("//*[@id='main-container']/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]");
		By FromTB = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div");
		By ToTB = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div/div[2]/input");
//	    By DeptDate = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]");
		By ReturnDate = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div[2]/div[1]");				
		By Passenger = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div");
		By Currency = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[2]/div/div[2]");
		By searchFlightBtn = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div");

		driver.findElement(FlightOption).click();
		wait(1000);
		driver.findElement(OneWayRB).click();
		wait(3000);
		driver.findElement(FromTB).sendKeys("Delhi");
		wait(1000);
		driver.findElement(ToTB).sendKeys("Mumbai (BOM)");
		wait(1000);

		WebElement dateChoice = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[4]/div"));				
		Actions actions = new Actions(driver);
		actions.moveToElement(dateChoice).click().build().perform(); 

		wait(800);
		if (driver.findElement(ReturnDate).isEnabled() == false) {
			System.out.print("It is one way Ticket");
		}
		
	//	wait(800);
	//	WebElement dateChoice2 = driver.findElement(By.xpath("//*[@id='main-container']/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[3]/div/div[3]/div[2]/div[7]/div/div"));
	//	Actions actions2 = new Actions(driver);
	//	actions2.moveToElement(dateChoice2).click().build().perform();

//	    Actions actions = new Actions(driver);
		WebElement Passengers = driver.findElement(Passenger);
		actions.moveToElement(Passengers).click().build().perform(); // for passenger 

		WebElement adultmore = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]"));
		WebElement doneBTN = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[2]/div"));
		wait(900);
		for (int i = 0; i < 1; i++) {
			actions.moveToElement(adultmore).click();
			wait(500);
		}
		actions.build().perform();
		wait(900);

		actions.moveToElement(doneBTN).click().perform();
		wait(500);

		driver.findElement(Currency).click();
		wait(1000);

		WebElement INR = driver.findElement(By
				.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[2]/div[2]/div[2]/div/div[1]"));
		actions.moveToElement(INR).click().build().perform();
		wait(2000);
		driver.findElement(searchFlightBtn).click();
		wait(8000);

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(40));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"main-container\"]/div/div[3]/div/div[1]/div[1]/div/div[1]")));

	}

	@Test(priority = 3)
	public void SelectFlight() {

		By continue1Button = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[5]/div/div/div[3]/div[2]");

		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(40));
		Actions actions = new Actions(driver);
		wait(1000);
		// radio button of "All flight"
		driver.findElement(By.xpath("//*[@id=\"list-results-section-0\"]/div[1]/div[2]/div[2]/div/div[2]/div")).click();
		wait(2000);
		// first flight, first radio button
		WebElement FirstFlight = driver.findElement(
				By.xpath("//*[@id=\"list-results-section-0\"]/div[5]/div[1]/div/div[2]/div[1]/div/div/div"));
		// if fight is available
		if (FirstFlight.isDisplayed() == true) {
			actions.moveToElement(FirstFlight).click().build().perform();
			wait(6000);
			waitElement.until(ExpectedConditions.visibilityOfElementLocated(continue1Button));
			wait(1000);
		} else {
			System.out.print("There is no flight Available");
			driver.quit();
		}

		wait(3000);
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SpiceMax']")));
		wait(1000);

		driver.findElement(continue1Button).click();

		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Trip Summary']")));
		wait(3000);
	}

	@Test(priority = 4)
	public void BookFlight() {
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions actions = new Actions(driver);
		wait(2000);
		actions.click(driver.findElement(By.xpath("//*[@id='pax-item-MSFBRFQ-']/div/div/div/div[2]")));
		wait(800);

		// PASSENGER PART1
		By p1firstandmiddlename = By
				.xpath("//*[@id='pax-item-MCFBRFQ-']/div[2]/div/div/div[2]/div[2]/div/div/div[2]/input");
		By p1lastname = By.xpath("//*[@id='pax-item-MCFBRFQ-']/div[2]/div/div/div[2]/div[3]/div/div/div[2]/input");
		By p1mobilenumber = By
				.xpath("//*[@id='pax-item-MCFBRFQ-']/div[2]/div/div/div[2]/div[4]/div/div[1]/div/div[2]/input");

		driver.findElement(p1firstandmiddlename).clear();
		driver.findElement(p1firstandmiddlename).sendKeys("BHANU");
		wait(800);

		driver.findElement(p1lastname).clear();
		driver.findElement(p1lastname).sendKeys("REDDY");
		wait(800);

		driver.findElement(p1mobilenumber).clear();
		driver.findElement(p1mobilenumber).sendKeys("9876543210");
		wait(800);

		// PASSANGER PART2
		By Passenger2 = By.xpath("//*[@id='pax-item-MSFBRFQ-']/div/div/div/div[2]");

		By p2firstandmiddlename = By
				.xpath("//*[@id='pax-item-MSFBRFQ-']/div[2]/div/div/div[1]/div[2]/div/div/div[2]/input");
		By p2lastname = By.xpath("//*[@id='pax-item-MSFBRFQ-']/div[2]/div/div/div[1]/div[3]/div/div/div[2]/input");
		By p2mobilenumber = By
				.xpath("//*[@id='pax-item-MSFBRFQ-']/div[2]/div/div/div[1]/div[4]/div/div[1]/div/div[2]/input");

		wait(2000);
		driver.findElement(Passenger2).click();

		wait(2000);

		driver.findElement(p2firstandmiddlename).sendKeys("REKHA");
		wait(800);

		driver.findElement(p2lastname).sendKeys("REDDY");
		wait(800);

		driver.findElement(p2mobilenumber).sendKeys("9182736450");
		wait(800);

		driver.findElement(By.xpath("//*[@id='travellers-view']/div[2]/div/div/div[2]")).click();
		wait(800);

		// next page element
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='main-container']/div/div[5]/div/div/div[2]/div/div/div[1]/div[1]/div[1]")));
		wait(800);

	}

//	@Test(priority = 5)
//	public void ConfirmBooking() {

//		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20));
//		Actions actions = new Actions(driver);

//		driver.findElement(
//				By.xpath("//*[@id='addons-container']/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/div/div"))
//				.click();
//		// selecting 1B seat
//		actions.moveToElement(driver.findElement(By.xpath(
//				"//*[@id='main-container']/div/div[1]/div/div/div[3]/div[9]/div/div[4]/div[2]/div/div/div[2]/div")))
//				.click();

//		System.out.println("The last Continue Button for payment is not clicked deliberatly");

//	}

	@Test(priority = 6, enabled = true)
	public void LogOut() {

		Actions actions = new Actions(driver);

		By LogoutDD = By.xpath("//*[@id='main-container']/div/div[1]/div/div[3]/div[1]");
		By LogoutBTN = By.xpath("//*[@id='main-container']/div/div[1]/div/div[3]/div[2]/div[3]");

		actions.click(driver.findElement(LogoutDD));
		wait(1000);
		actions.moveToElement(driver.findElement(LogoutBTN)).click().build().perform();

	}

}
