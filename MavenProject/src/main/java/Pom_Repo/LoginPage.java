package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	//Create a constructor
		WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(name = "user_name")
		private WebElement usernameTF;
		
		@FindBy(name = "user_password")
		private WebElement passwordTF;
		
		//@FindAll({@FindBy(id = "submitButton"), @FindBy(xpath = "//input[@value='Login' and @type='submit']")})
		@FindBy(id = "submitButton")
		private WebElement loginBtn;

		public WebElement getUsernameTF() {
			return usernameTF;
		}

		public WebElement getPasswordTF() {
			return passwordTF;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//business method/logic/library
		public void loginToCRM(String username, String password) {
			usernameTF.sendKeys(username);
			passwordTF.sendKeys(password);
			loginBtn.click();
		}
		
}
