package sjtests;

import java.awt.AWTException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import sjpages.BasePage;
import sjpages.LoginPage;
import sjpages.SignupPage;
import sjpages.WelcomePage;

public class SignupPageTest extends BasePage {	
@Test
	public void signup() throws InterruptedException, AWTException {
		WelcomePage welcomePage = new WelcomePage(driver);
		String oldTab = driver.getWindowHandle();
		welcomePage.clicksignup();
		Thread.sleep(6000);
		
		// considering that there is only one tab opened in that point.
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	   
	    Thread.sleep(2000);
		SignupPage signupPage = new SignupPage(driver);		
	    signupPage.selectTitle("Mr");
	    signupPage.typeFullmiddlename("admin");
		signupPage.typeLastname("reddy");		
		signupPage.selectCountry("India");
		signupPage.selectCalenderDDMMYY("20","06","1999");
		signupPage.typeMobileno("9440422243");
		Thread.sleep(2000);
		signupPage.typeEmailid("admin123@gmail.com");		
		signupPage.typePassword("Admin@789");
		signupPage.typeConfirmpassword("Admin@789");	
		 Thread.sleep(2000);
		signupPage.clickCheckbox();	
		Thread.sleep(2000);
		signupPage.clickSubmit();
	//	signupPage.clickBooknow();
		//  you are in the new tab
	    
	    driver.close();
	    // change focus back to old tab
	    driver.switchTo().window(oldTab);
	    //  you are in the old tab
					    
}

@Test
public void verifyErrorMessageOnSignUpPage() throws InterruptedException, AWTException {
	WelcomePage welcomePage = new WelcomePage(driver);
	String oldTab = driver.getWindowHandle();
	welcomePage.clicksignup();
	Thread.sleep(9000);
	
	// considering that there is only one tab opened in that point.
    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
    newTab.remove(oldTab);
    // change focus to new tab
    driver.switchTo().window(newTab.get(0));
   
    Thread.sleep(2000);
	SignupPage signupPage = new SignupPage(driver);		
	signupPage.clickSubmit();
	
	Assert.assertEquals(signupPage.verifyerrormsg(), "Please fill all mandatory fields marked with an '*' to proceed");
	
    
    driver.close();
    // change focus back to old tab
    driver.switchTo().window(oldTab);
    //  you are in the old tab
				    
}


}