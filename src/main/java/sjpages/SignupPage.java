package sjpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupPage {
	
	By errorMsg =  By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[1]");
	By titleField = By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/select");
	By fullmiddlenameField = By.xpath("//input[@id='first_name']");
	By lastnameField = By.xpath("//input[@id='last_name']");
	By countryField = By.xpath("//select[@class='form-control form-select']");
	By dateofbirthField = By.xpath("//input[@id='dobDate']");
	By mobilenoField = By.xpath("(//input[@placeholder='+91 01234 56789'])[1]");
	By emailidField = By.xpath("//input[@id='email_id']");
	By passwordField = By.xpath("//input[@id='new-password']");
	By confirmpasswordField = By.xpath("//input[@id='c-password']");
	By checkboxButton = By.xpath("//input[@id='defaultCheck1']");
	By submitBtn = By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[7]/div[1]/a/button");
	
	By booknowButton = By.xpath("//ul[@class='nav btn-nav']//li[@class='nav-item']//a");
	
	
	
		
	WebDriver driver;
	WebDriverWait wait;
	
	public SignupPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		//wait = new WebDriverWait(driver, 10);
	}
	
	
	
	public void selectCalenderDDMMYY(String Date,String Month, String Year) throws InterruptedException {
	
		String dateXpath = "//div[contains(@class,'react-datepicker__day react-datepicker__day--0"+Date+"')]";
		
		By selectDate = By.xpath(dateXpath);
		By selectmonth = By.xpath("//select[@class='react-datepicker__month-select']");
		By selectyear = By.xpath("//select[@class='react-datepicker__year-select']");
		
		
		clickOnDobCalender();
		
		Thread.sleep(2000);
		WebElement selectMonth=driver.findElement(selectmonth);
		String month;
		int months = 0;
		
		switch(Month) {
			case "01": months = 0;
			break;
			case "02": months = 1;
			break;
			case "03": months = 2;
			break;
			case "04": months = 3;
			break;
			case "05": months = 4;
			break;
			case "06": months = 5;
			break;
			case "07": months = 6;
			break;
			case "08": months = 7;
			break;
			case "09": months = 8;
			break;
			case "10": months = 9;
			break;
			case "11": months = 10;
			break;
			case "12": months = 11;
			break;
			
			default:System.out.println("please provide correct month number");
			break;
		}
		
		
		Select selectMM=new Select(selectMonth);
		selectMM.selectByValue(Integer.toString(months));
		
		Thread.sleep(2000);
		WebElement selectYear=driver.findElement(selectyear);
		Select selectYY=new Select(selectYear);
		selectYY.selectByVisibleText(Year);
		
		Thread.sleep(2000);
		driver.findElement(selectDate).click();
		Thread.sleep(1000);
		
	}
	
	public boolean errorMsgDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).isDisplayed();
	}
	
	public String verifyerrormsg() throws InterruptedException {
		Thread.sleep(3000);
		String msg=driver.findElement(errorMsg).getText().trim();
		return msg;
	}
	
	public void selectTitle(String title) {
		WebElement selectelement=driver.findElement(titleField);
		Select select=new Select(selectelement);
		select.selectByVisibleText(title);
	}
	
	public void typeFullmiddlename(String fullmiddlename) { 
		driver.findElement(fullmiddlenameField).clear();
		driver.findElement(fullmiddlenameField).sendKeys(fullmiddlename);
	}
	
	public void typeLastname(String lastname) { 		
		driver.findElement(lastnameField).sendKeys(lastname);
	}
	
	public void selectCountry(String country) {
		WebElement selectelement=driver.findElement(countryField);
		Select select=new Select(selectelement);
		select.selectByVisibleText(country);
	}
		
	
	public void clickOnDobCalender() throws InterruptedException { 	
		Thread.sleep(2000);
		driver.findElement(dateofbirthField).click();
	}
			
	public void typeMobileno(String mobileno) { 		
		driver.findElement(mobilenoField).sendKeys(mobileno);
	}
	
	public void typeEmailid(String emailid ) throws InterruptedException { 	
		Thread.sleep(3000);
		 Actions actions=new Actions(driver);
	     actions.scrollToElement(driver.findElement(emailidField)).doubleClick();
		driver.findElement(emailidField).sendKeys(emailid);
	}
	
	public void typePassword(String password) throws InterruptedException { 
		Thread.sleep(3000);
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void typeConfirmpassword(String confirmpassword ) throws InterruptedException { 
		
        Actions actions=new Actions(driver);
        actions.scrollToElement(driver.findElement(confirmpasswordField)).doubleClick();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(confirmpasswordField)).sendKeys(confirmpassword);
		//.sendKeys(confirmpassword);
	}
	
	public void clickCheckbox() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(checkboxButton).click();
	}
	
	public void clickSubmit() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		
		// Scroll Down using Robot class
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
 
				
		Thread.sleep(2000);
		driver.findElement(submitBtn).click();
	}
	
	public void clickBooknow() {
		driver.findElement(booknowButton).click();
	}
	
	
}
