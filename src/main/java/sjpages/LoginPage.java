package sjpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	By mobilenumberradioButton = By.xpath("/*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[1]/div[1]");
	By emailidradioButton = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div[1]");
	By mobilenumberField = By.xpath("//input[@type='number']");
	By passwordField = By.xpath("//input[@type='password']");
	By loginBtn = By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[3]");
		
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		//wait = new WebDriverWait(driver, 10);
	}

	
	public void clickMobilenumberradiobutton() {
		driver.findElement(mobilenumberradioButton).click();
	}
	
	public void clicEmailidradiobutton() {
		driver.findElement(emailidradioButton).click();
	}
			
	public void typeMobilenumber(String mobilenumber) { //pass a parameter so we don't hardcode values in the object class.
		driver.findElement(mobilenumberField).clear();
		driver.findElement(mobilenumberField).sendKeys(mobilenumber);
	}
	
	public void typePassword(String password) { 
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	
	
	

}
