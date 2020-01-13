package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	@FindBy(id = "username") WebElement userName;
	@FindBy(xpath ="//*[contains(name,'pwd')]") public WebElement password;
	@FindBy(xpath = "//*[contains(@id,'loginButton')]") WebElement loginButton;
	@FindBy(xpath = "//*[contains(class,'errormsg')]") WebElement errorMsg;
	@FindBy(xpath = "//*[contains(@id,'toPasswordRecoveryPageLink')]") WebElement forgotPassword;
	@FindBy(id = "logoutLink") WebElement logOut;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void enterUsername(String username){
		userName.sendKeys(username);     
    }
	
	public void enterPassword(String pwd){
		password.sendKeys(pwd);     
    }
	
	public void checkLogout()
	{
		logOut.isDisplayed();
	}
	
	public String errorMsg() {
	   return errorMsg.getText();
	}
	
	
	
	public void clickLogout()
	{
		logOut.click();
	}
	
	public void verifyLoginpage()
	{
		userName.isDisplayed();
		password.isDisplayed();
		loginButton.isDisplayed();
	}
}

