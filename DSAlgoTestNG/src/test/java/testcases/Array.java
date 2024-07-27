package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class Array extends BaseTest {
	
	@Test
	public void TC_01_NavigateToArrayFromDropDown() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		homePage.navigateToArrayFromDropDown();
		
		System.out.println("Title:" +driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Array");
		
	}
	public void TC_02_ValidateLinksInArrayModule() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		homePage.navigateToArrayFromDropDown();
		Assert.assertEquals(driver.getTitle(), "Array");
		
		
	}

}
