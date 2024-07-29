package testcases;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTestCases extends BaseTest {
	
	@Test
	public void TC_01_RegisterSuccessful() {
		String username ="techtitans06";
		HomePage homePage = new HomePage(driver);
		homePage.clickRegister();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterUsername(username);
		registerPage.enterPassword("Time2fly$");
		registerPage.enterPasswordConfirmation("Time2fly$");
		registerPage.clickRegisterBtn();
		
		String expectedMessage ="New Account Created. You are logged in as" +username;
		homePage.validateMsgAfterRegistration(expectedMessage,username);
		
		
	}
	
	@Test
	public void TC_02_ValidateRegistrationFormEmptyData() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickRegister();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterUsername("");
		registerPage.enterPassword("");
		registerPage.enterPasswordConfirmation("");
		registerPage.clickRegisterBtn();
		
		String expectedMessage ="Please fill out this field.";
		registerPage.validateToolTipErrorMsgRegistration(expectedMessage);
		
		
	}
	
	@Test
	public void TC_03_ValidateRegistrationFormInvalidData() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickRegister();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterUsername("abc");
		registerPage.enterPassword("1");
		registerPage.enterPasswordConfirmation("2");
		registerPage.clickRegisterBtn();
		
		String expectedMessage ="password_mismatch:The two password fields didn’t match.";
		registerPage.validateErrorMsgRegistration(expectedMessage);
		
		
	}

}
