package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	
	WebDriver driver;

	public CreateNewCampaignPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignname")
	private WebElement campaignName;

	@FindBy(name = "closingdate")
	private WebElement closeDate;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCloseDate() {
		return closeDate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createCampWithCloseDate(String campName, String dateClose) {
		campaignName.sendKeys(campName);
		closeDate.clear();
		closeDate.sendKeys(dateClose);
		saveBtn.click();
	}

}
