package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import driverManager.DriverFactory;

public class BaseTest {
	
	 protected WebDriver driver;
	    private DriverFactory driverFactory;

	    @BeforeMethod
	    public void setUp() {
	    	driverFactory = new DriverFactory();
	        driver = driverFactory.initializeDriver();
	    }

	    @AfterMethod
	    public void tearDown() {
	    	driverFactory.quitDriver();
	    }

}
