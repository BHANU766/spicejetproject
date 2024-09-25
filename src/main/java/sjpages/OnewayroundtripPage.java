package sjpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnewayroundtripPage {
   	
	By roundtripradioButton = By.xpath("//*[@id='main-container']/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]");
	By fromField = By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2'][normalize-space()='From']");
	By delhiField = By.xpath("//input[@value='Delhi (DEL)']");
	By toField = By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2'][normalize-space()='To']");
	By selectdestinationField = By.cssSelector("input[value='Select Destination']");
	By departuredateField = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]/div[1]");
	By dateField = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]/div[2]");
	By returndateField = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div[1]");
	By selectField = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div[2]");	
	By searchflightButton = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div");
	
	
	WebDriver driver;
	WebDriverWait wait;
	

	public OnewayroundtripPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		//wait = new WebDriverWait(driver, 10);
	}
	
	public void clickRoundtripradio() {
		driver.findElement(roundtripradioButton).click();
	}
	
	public boolean fromFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(fromField)).isDisplayed();
	}
	
	public boolean delhiFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(delhiField)).isDisplayed();
	}
	
	public boolean toFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(toField)).isDisplayed();
	}
	
	public void typeSelectdestination(String selectdestination) { 
		driver.findElement(selectdestinationField).clear();
		driver.findElement(selectdestinationField).sendKeys(selectdestination);
	}
	
	public boolean departuredateFieldDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(departuredateField)).isDisplayed();
	}
	
	public void selectdate(String date) {
		WebElement dateChoice = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[1]/div/div[3]/div[5]/div[4]/div"));
		Actions actions = new Actions(driver);														
		actions.moveToElement(dateChoice).click().build().perform();
	}
					
	public void selectdate2(String date) {
		WebElement dateChoice2 = driver.findElement(By.xpath("//*[@id='main-container']/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[3]/div/div[3]/div[1]/div[5]/div/div"));
		Actions actions = new Actions(driver);
		actions.moveToElement(dateChoice2).click().build().perform();
	}
	
	public void clickSearchflight() {
		driver.findElement(searchflightButton).click();
	}
	

	public void selectDate(String month_year, String day) throws InterruptedException {

		 // For selecting month and year

		  List<WebElement> months = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));

		   System.out.println("months count: " +months.size());     

		   for (int i = 0; i < months.size(); i++) {

		    // Select date corresponding to the the month

		    if (months.get(i).getText().equals(month_year)) {

		   List<WebElement> days = driver.findElements(By.xpath("(//div[@class='DayPicker-Caption']/div)[" + i

		    + "+1]/..//following-sibling::div[@class='DayPicker-Body']//div[@class='DayPicker-Day']//p"));

		    System.out.println("days count: " + days.size());

		     for (int j = 0; j < days.size(); j++) {

		    if (days.get(j).getText().equals(day)) {

		    days.get(j).click();

		      break;

		     }

		      }

		       }

		        }      

		         }
		
}


	

