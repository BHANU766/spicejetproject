package sjtests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import sjpages.BasePage;
import sjpages.ValidatefieldsPage;
import sjpages.WelcomePage;

public class ValidatefieldsPageTest extends BasePage{	
@Test
	public void fieldsvalidation() throws InterruptedException, AWTException {
		WelcomePage welcomePage = new WelcomePage(driver);
		
		ValidatefieldsPage validatefieldsPage = new ValidatefieldsPage(driver);
		validatefieldsPage.clickCheckin();
		validatefieldsPage.clickFlightstatus();
		validatefieldsPage.clickManagebooking();
}
}