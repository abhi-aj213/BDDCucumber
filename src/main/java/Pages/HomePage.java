package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	
	
	@FindBy(id = "logo_aT") WebElement actiTimeLogo;
	@FindBy(id = "logoutLink") WebElement logOut;

	@FindBy(xpath = "//*[contains(text(),'Time-Track')]") WebElement entertimetrackTab;
	@FindBy(xpath = "//*[contains(text(),'View Time-Track')]") WebElement viewtimetrackTab;
	@FindBy(xpath = "//*[contains(text(),'Lock Time-Track')]") WebElement locktimetrackTab;
	@FindBy(xpath = "//*[contains(text(),'Approve Time-Track')]") WebElement approvetimetrackTab;
	@FindBy(xpath = "//*[contains(text(),'Tasks')]") WebElement taskTab;
	@FindBy(xpath = "//*[contains(text(),'Reports')]") WebElement reportsTab;
	@FindBy(xpath = "//*[contains(text(),'Users')]") WebElement usersTab;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkLogout()
	{
		logOut.isDisplayed();
	}
		

	
	public void verifyHomepage() {
		actiTimeLogo.isDisplayed();
		logOut.isDisplayed();
		entertimetrackTab.isDisplayed();
		viewtimetrackTab.isDisplayed();
		locktimetrackTab.isDisplayed();
		approvetimetrackTab.isDisplayed();
		taskTab.isDisplayed();
		reportsTab.isDisplayed();
		usersTab.isDisplayed();
		}
	
	
	
}
