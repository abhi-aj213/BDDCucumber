package StepDefinations;

import cucumber.api.java.en.Given;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.ReusableFunctions;
import Pages.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class loginPageSteps {

	WebDriver driver;

	ReusableFunctions rf = new ReusableFunctions();
		
	@Given("^User navigates to application login page using ([^\"]*)$")
	public void UserNavigatesToApplicatioLoginPage(String Url){
		
			try {
				driver=	rf.setup("chrome");
				driver.get(Url);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		
	}
	
	
	@When("^User enter valid credentials ([^\"]*) and ([^\"]*)$")
	public void UserEnterValidCredential(String Username,String password) throws IOException {
		LoginPage lp =PageFactory.initElements(driver,LoginPage.class);
		lp.enterUsername(Username);
		lp.enterPassword(ReusableFunctions.pReader("apppassword"));
		lp.clickLogin();
	}
	
	@When("^User enter invalid credentials ([^\"]*) and ([^\"]*)$")
	public void UserEnterInvalidCredential(String Username,String password) throws IOException {
		LoginPage lp =PageFactory.initElements(driver,LoginPage.class);
		lp.enterUsername(Username);
		lp.enterPassword(ReusableFunctions.pReader("invalidpassword"));
		lp.clickLogin();
	}
	
	@Then("^Error message should be displayed$")
	public void ErrorMessageShouldBeDisplayed () {
		LoginPage lp =PageFactory.initElements(driver,LoginPage.class);
	String errorMsg = "Invalid username or password. Please try again.";	
		if (errorMsg == lp.errorMsg())
			System.out.println("Pass");
		
		driver.close();
	}
	
	@Then("^User should be on home page$")
	public void UsershouldBeOnHomepage () {
		LoginPage lp =PageFactory.initElements(driver,LoginPage.class);
		lp.checkLogout();
		driver.close();
		
	}
	
	@Then("^User click on logout$")
	public void UserClickOnLogout () {
		LoginPage lp =PageFactory.initElements(driver,LoginPage.class);
		lp.clickLogout();
	}
	
	



	@Then("^Login Page is displayed$")
	public void loginPageIsDisplayed() throws Throwable {
		LoginPage lp =PageFactory.initElements(driver,LoginPage.class);
		lp.verifyLoginpage();
		driver.close();
	}


	@Given("^User navigates to application login page$")
	public void userNavigatesToApplicationLoginPage() throws Throwable {
		try {
			driver=	rf.setup("Chrome");
			driver.get(ReusableFunctions.pReader("url"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	}