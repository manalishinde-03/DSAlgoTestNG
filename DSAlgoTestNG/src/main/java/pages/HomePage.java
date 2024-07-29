package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage {

	
	WebDriver driver;

	@FindBy(xpath ="//ul/a[3]" )
	WebElement link_SignOut;
	
	@FindBy(linkText ="Sign in" )
	WebElement link_SignIn;
	
	@FindBy(xpath ="//div[@class='alert alert-primary']" )
	WebElement text_loginSuccessMsg;
	
	@FindBy(xpath ="//ul/a[2]" )
	WebElement text_username;
	 @FindBy(xpath="//a[text()='Arrays']") WebElement Arrayoptions;
	@FindBy(xpath ="//button[text()='Get Started']" )
	WebElement btn_GetStarted;
	@FindBy(xpath ="//a[@class='nav-link dropdown-toggle']" )
	WebElement dropDownDataStructures;
	@FindBy(xpath ="//div/a[@class='dropdown-item']" )
	List<WebElement> dropDownDataStructuresValues;
	@FindBy(linkText ="Register")
	WebElement link_Register;
	@FindBy(linkText ="Get Started")
	WebElement btn_GetStartedHome;
	@FindBy(linkText ="NumpyNinja")
	WebElement link_NumpyNinja;
	@FindBy(xpath ="//form[@method='post']" )
	WebElement registrationForm;
	@FindBy(xpath ="//form[@method='post']" )
	WebElement loginForm;
	@FindBy(xpath ="//div[@class='alert alert-primary']" )
	WebElement text_UserNotLoggedInWarning;
	@FindBy(xpath ="//div[@class='alert alert-primary']" )
	WebElement text_registerSuccessMsg;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void validateMsgAfterLogin(String expectedMessage) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actualMsg = text_loginSuccessMsg.getText();
		
		  Assert.assertEquals(actualMsg,expectedMessage);
		//  LoggerLoad.info("Login Successful!");
	}
	
	
	public void validateMsgAfterRegistration(String message, String username) {
		String registerSuccessMsg = text_registerSuccessMsg.getText();
		String expectedSuccessMsg = message+" "+username;  
		
		Assert.assertEquals(registerSuccessMsg,expectedSuccessMsg);
		System.out.println("Registration Successful!");
	}
	
	public void validateUserLandedOnHomePage() {
		  this.driver.getPageSource().contains("NumpyNinja");
		 System.out.println("User landed on Home page!");
	}
	
	public void validateDataStructuresDropdown() {
		dropDownDataStructures.click();
		   
		List <WebElement> dsOptions = dropDownDataStructuresValues;
		String expectedOptions [] = {"Arrays", "Linked List","Stack","Queue","Tree","Graph"};
		
		for (int i = 0; i < dsOptions.size(); i++) {
			dsOptions.get(i).getText();
			Assert.assertEquals(dsOptions.get(i).getText(), expectedOptions[i]);
		}
	}
	public void clickSignIn() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(link_SignIn)).click();
		
		Assert.assertEquals(driver.getTitle(),"Login");
		//LoggerLoad.info("User landed on Login page!");
	}
	public void clickSignOut() {
		link_SignOut.click();
	}
	public void clickGetStartedOnHomePage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		btn_GetStartedHome.click();
		 
	}
	
	public void clickNumpyNinjaLink() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		link_NumpyNinja.click();
		Assert.assertEquals(driver.getTitle(),"Numpy Ninja");
		//LoggerLoad.info("User landed on Landing page");
		 
	}
	public void clickRegister() {
		link_Register.click();
		Assert.assertEquals(driver.getTitle(),"Registration");
		//LoggerLoad.info("User landed on Register page!");
	}

	public void verifyUsernameSignOutLinkOnHomePage(String username) {
		 String actualUserName = text_username.getText();
		  String usernameLowerCase = actualUserName.toLowerCase();
		  
		  Assert.assertEquals( usernameLowerCase,username);
		  //LoggerLoad.info("Username is displayed to top right corner on Home page");
		  
		  if(link_SignOut.isDisplayed()) {
			  System.out.println("Sign out link is displayed");
			  //LoggerLoad.info("Sign out link is displayed");
			} else {
				System.out.println("Sign out link is NOT displayed");
				//LoggerLoad.info("Sign out link is NOT displayed");
			}
	}
	public void validateWarningUserNotLoggedIn(String expectedWarning) {
		 this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 String actualWarningMsg = text_UserNotLoggedInWarning.getText();
		  
		 Assert.assertEquals(expectedWarning, actualWarningMsg);
	}

	public void clickGetStartedBtn() {
		btn_GetStarted.click();
	}

	/*
	 * public void validateMsgFromExcelAfterRegistration(String sheetname, int row)
	 * throws InvalidFormatException, IOException { ExcelReader reader = new
	 * ExcelReader();
	 * 
	 * List<Map<String, String>> testdata =
	 * reader.getData("./src/test/resources/ExcelTestData/LoginData.xlsx",
	 * sheetname); String expectedMessage = testdata.get(row).get("message"); String
	 * username = testdata.get(row).get("username");
	 * validateMsgAfterRegistration(expectedMessage,username); }
	 */

	public void validateNavigationThroughDropdown(String option) {
		
		dropDownDataStructures.click();
		   
		List <WebElement> dsOptions = dropDownDataStructuresValues;
		for (int i = 0; i < dsOptions.size(); i++) { //A
			
			if(dsOptions.get(i).getText().contains("Arrays")) {
				dsOptions.get(i).click();
				String actualURL = driver.getCurrentUrl();
				String expURL ="https://dsportalapp.herokuapp.com/array/";
				Assert.assertEquals(actualURL, expURL);
				
				break;
			}
			else 
				if (dsOptions.get(i).getText().contains(option)){
				dsOptions.get(i).click();
				String pageTitle = driver.getTitle();
				Assert.assertEquals(pageTitle, option);
				
			}
		}
	}

	public void validateLogoutSuccessMsg(String expMessage) {
		WebElement signoutMsg=driver.findElement(By.xpath("//div[@class='alert alert-primary']"));
		System.out.println(signoutMsg.getText());
		Assert.assertEquals(signoutMsg.getText(), expMessage);
		
	}


	public void navigateToArrayFromDropDown() {
		driver.findElement(By.xpath("//a[text()='Data Structures']")).click();
		 Arrayoptions.click();
		
	}


}
