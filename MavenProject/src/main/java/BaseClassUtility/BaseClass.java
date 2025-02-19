package BaseClassUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Generic_Utility.PropertyFileUtility;
import Generic_Utility.WebDriver_Utility;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;

public class BaseClass {
	
	public PropertyFileUtility putil= new PropertyFileUtility();
	public WebDriver driver= null;
	public static WebDriver sdriver= null;
	public WebDriver_Utility wutil= new WebDriver_Utility();
	public HomePage hp= new HomePage(driver);
	
	@BeforeSuite(groups = {"RegressionTestCase", "SmokeTestCase"})
	public void configBS() {
		Reporter.log("Establish DB Connection", true);
	}
	@AfterSuite(groups = {"RegressionTestCase", "SmokeTestCase"})
	public void configAS() {
		Reporter.log("Disconnect DB Connection", true);
	}
	
	@BeforeTest(groups = {"RegressionTestCase", "SmokeTestCase"})
	public void configBT() {
		Reporter.log("Pre-Condition", true);
	}
	@AfterTest(groups = {"RegressionTestCase", "SmokeTestCase"})
	public void configAT() {
		Reporter.log("Post-Condition", true);
	}
	//@Parameters("BROWSER")// for Cross Browser parallel testing
	@BeforeClass(groups = {"RegressionTestCase", "SmokeTestCase"})
	public void configBC(/*String Browser*/) throws IOException {
		Reporter.log("Launching the Browser", true);
		//cross Browser Testing
		//String BROWSER=Browser;
		String BROWSER= putil.readDataFromProperties("Browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else {
			driver= new ChromeDriver();
			}
		sdriver=driver; //listeners implementation purpose
		String URL =putil.readDataFromProperties("Url");
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
	}
	
		
	@AfterClass(groups = {"RegressionTestCase", "SmokeTestCase"})
	public void configAC() {
		driver.quit();
		Reporter.log("Close the browser", true);
	}
	
	
	@BeforeMethod(groups = {"RegressionTestCase", "SmokeTestCase"})
	public void configBM() throws IOException {
		String UNAME = putil.readDataFromProperties("Username");
		String PWD = putil.readDataFromProperties("Password");
		LoginPage lp= new LoginPage(driver);
		lp.loginToCRM(UNAME, PWD);
		Reporter.log("Login Successfull", true);
	}
	
	@AfterMethod(groups = {"RegressionTestCase", "SmokeTestCase"})
	public void configAM() {
		HomePage hp= new HomePage(driver);
		hp.logoutFromCRM();
		Reporter.log("Logout", true);
	}


}
