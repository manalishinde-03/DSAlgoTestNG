package testcases;

import org.testng.annotations.Test;

import pages.CommonPage;
import pages.GraphPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.LoggerLoad;

public class GraphTestCases extends BaseTest {
	
	@Test
	public void TC_01_NavigationToGraph() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		CommonPage commonPage = new CommonPage(driver);
		commonPage.Handledropbox();
		GraphPage Graph = new GraphPage(driver);
		Graph.GraphOptions();
		LoggerLoad.info("Title:" +driver.getTitle());
		System.out.println("Title:" +driver.getTitle());
		
	}
	
	@Test
	public void TC_02_ValidateGraphLinkWithPythonCode() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		CommonPage commonPage = new CommonPage(driver);
		commonPage.Handledropbox();
		GraphPage GraphPage = new GraphPage(driver);
		GraphPage.GraphOptions();
		LoggerLoad.info("Title:" +driver.getTitle());
		System.out.println("Title:" +driver.getTitle());
		GraphPage.Graph(driver, 5);
		
		commonPage.click_tryhere_with_timeout(driver, 20);
		commonPage.try_python_script(driver, "print(\"Hello\")");
		
	}
	
	@Test
	public void TC_03_ValidateGraphRepresentationLinkWithPythonCode() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		CommonPage commonPage = new CommonPage(driver);
		commonPage.Handledropbox();
		GraphPage GraphPage = new GraphPage(driver);
		GraphPage.GraphOptions();
		System.out.println("Title:" +driver.getTitle());
		GraphPage.GraphRepresentations();
		
		commonPage.click_tryhere_with_timeout(driver, 20);
		commonPage.try_python_script(driver, "print(\"Hello\")");
		
	}
	
	@Test
	public void TC_04_ValidateGraphLinkWithInvalidPythonCode() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		CommonPage commonPage = new CommonPage(driver);
		commonPage.Handledropbox();
		GraphPage GraphPage = new GraphPage(driver);
		GraphPage.GraphOptions();
		System.out.println("Title:" +driver.getTitle());
		GraphPage.Graph(driver, 5);
		
		commonPage.click_tryhere_with_timeout(driver, 20);
		commonPage.try_python_script(driver, "print((\"hello\");;");
		
	}
	
	@Test
	public void TC_05_ValidateGraphRepresentationLinkWithInvalidPythonCode() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterDataForLogin("techtitans", "Time2fly$");
		loginPage.clickLoginBtn();
		
		CommonPage commonPage = new CommonPage(driver);
		commonPage.Handledropbox();
		GraphPage GraphPage = new GraphPage(driver);
		GraphPage.GraphOptions();
		System.out.println("Title:" +driver.getTitle());
		GraphPage.GraphRepresentations();
		
		commonPage.click_tryhere_with_timeout(driver, 20);
		commonPage.try_python_script(driver, "print((\"hello\");;");
		
	}

}
