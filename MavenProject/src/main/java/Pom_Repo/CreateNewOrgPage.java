package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;


public class CreateNewOrgPage {
	
	WebDriver driver;

	public CreateNewOrgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement organizationTF;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrganizationTF() {
		return organizationTF;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void typeAndIndustry(String organizationName, String industry, String type) {
		organizationTF.sendKeys(organizationName);
		WebDriver_Utility wutil= new WebDriver_Utility();
		wutil.select(industryDD, industry);
		wutil.select(typeDD, type);
		saveBtn.click();
	}


}
