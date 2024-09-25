package sjpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spicejet.Spicejet;

public class WelcomePage {

	By spicejetField = By.xpath("//*[@id=\\\"main-container\\\"]/div/div[1]/div[2]/div[2]/div/div[1]/div");
	By hotelsField = By.xpath("//div[text()='Hotels']");
	By addonsField = By.xpath("//div[text()='Add-ons']");
	By dealsField = By.xpath("//div[text()='Deals']");
	By giftcardField = By.xpath("//div[text()='Gift Card']");
	By spiceclubField = By.xpath("//div[text()='SpiceClub']");
	By spicescreenField = By.xpath("//div[text()='SpiceScreen']");
	By taxiField = By.xpath("//*[@id=\\\"main-container\\\"]/div/div[1]/div[2]/div[2]/div/div[2]/a[5]/div");
	By cargoField = By.xpath("//*[@id=\\\"main-container\\\"]/div/div[1]/div[2]/div[2]/div/div[2]/a[6]/div");
	By spiceholidaysField = By.xpath("//div[text()='SpiceHolidays']");
	By charterField = By.xpath("//*[@id='main-container']/div/div[1]/div[2]/div[2]/div/div[2]/a[8]/div/div");
	By signupButton = By.xpath("//*[@id='main-container']/div/div[1]/div[2]/div[1]/div/div[3]/div[2]/div/a/div");
	By loginButton = By.xpath("//div[text()='Login']");
	
		WebDriver driver;
		WebDriverWait wait;
	
	
	public WelcomePage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		//wait = new WebDriverWait(driver, 10);
	}
	
	public boolean spicejetFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(spicejetField)).isDisplayed();
	}
	
	public boolean hotelsFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(hotelsField)).isDisplayed();
	}
	
	public boolean addonsFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(addonsField)).isDisplayed();
	}
	
	public boolean dealsFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(dealsField)).isDisplayed();
	}
	
	public boolean  giftcardFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated( giftcardField)).isDisplayed();
	}
	
	public boolean spiceclubFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(spiceclubField)).isDisplayed();
	}
	
	public boolean spicescreenFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(spicescreenField)).isDisplayed();
	}
	
	public boolean taxiFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(taxiField)).isDisplayed();
	}
	
	public boolean cargoFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cargoField)).isDisplayed();
	}
	
	public boolean spiceholidaysFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(spiceholidaysField)).isDisplayed();
	}
	
	public boolean charterFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(charterField)).isDisplayed();
	}
	
	public void clicksignup() throws InterruptedException {
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(signupButton)).perform();
		driver.findElement(signupButton).click();
	}	
	public void clicklogin() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(loginButton).click();
		Thread.sleep(2000);
	
	}
	


}
