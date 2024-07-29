package testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.LoggerLoad;

public class LoginTestCases extends BaseTest {
	
	@Test
	public void TC_01_LoginSuccessful() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		homePage.validateMsgAfterLogin("You are logged in");
		LoggerLoad.info("Title:" +driver.getTitle());
		System.out.println("Title:" +driver.getTitle());
		
	}
	
	@Test
	public void TC_02_UsernameFieldEmpty() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin(" ", "Time2fly$");
		loginPage.clickLoginBtn();
		
		loginPage.validateToolTipErrorMsg("Please fill out this field.");
		
	}
	@Test
	public void TC_03_PasswordFieldEmpty() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", " ");
		loginPage.clickLoginBtn();
		
		loginPage.validateToolTipErrorMsg("Please fill out this field.");
		
	}
	
	@Test
	public void TC_04_InvalidLoginCredentials() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "1234");
		loginPage.clickLoginBtn();
		
		loginPage.validateErrorMsg("Invalid Username and Password");
		
	}
	

	@Test
	public void TC_05_LogoutSuccessful() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		homePage.clickSignOut();
		homePage.validateLogoutSuccessMsg("Logged out successfully");
		
		
	}

}
