package sjtests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sjpages.LoginPage;
import sjpages.WelcomePage;
import sjpages.BasePage;

public class LoginPageTest extends BasePage{
@Test
	public void accountlogin() throws InterruptedException {
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.clicklogin();
				
		LoginPage loginPage = new LoginPage(driver);
	//	loginPage.clickMobilenumberradiobutton();
		loginPage.typeMobilenumber("9440422243");
		loginPage.typePassword("Admin@123");		
		loginPage.clickLogin();
		Thread.sleep(2000);
		
	}


}	
