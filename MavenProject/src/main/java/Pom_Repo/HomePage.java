package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void logoutFromCRM() {
		WebDriver_Utility wutil= new WebDriver_Utility();
		wutil.moveToElement(driver, administrator);
		signOutLink.click();
	}
	
	public void goToCampaign() {
		moreLink.click();
		campLink.click();
	}
	

}