package sjpages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {

	public static WebDriver driver;
	String url = "https://www.spicejet.com/";
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeSuite
	public void setup(ITestContext context) {
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		context.setAttribute("WebDriver", driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		System.out.println("Test Step:  LOGIN -> FLIGHT FINDER -> SELECT FLIGHT -> BOOK FLIGHT -> FLIGHT CONFIRMATION -> LOGOUT");
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
		
	
	//METHOD 1 : for wait
		public static void wait(int wt) {	
			try {
				Thread.sleep(wt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//METHOD2
		public static void captureScreenshot(String msg) {							// FOR SCREEENSHOT

			System.out.println("Screenshot for " + msg);
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss"); //yyyy-MM-dd
			String dateTime = sdf.format(date);
			String fileName = "screenshot_" + dateTime;
			
			
			TakesScreenshot scrShot = (TakesScreenshot) driver;
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(".\\src\\test\\resources\\Screenshots\\" + fileName + ".png");		// EXPLAIN PATH!   . FOR CURRENT PROJECT FOLDER -> src->test-> resources -> screenshot
			
			
				try {
					FileUtils.copyFile(srcFile, destFile);										// TO COPY SCREENSHOT FILE IN DESTINATION FILE 
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
		}
		
	
	
}
