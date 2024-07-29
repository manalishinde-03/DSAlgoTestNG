package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {

	public WebDriver driver;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement Run;
	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement Signout;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement text_output;
	@FindBy(linkText ="Try here>>>" )
	WebElement btn_tryHere;


	// Constructor

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// methods

	public void Handledropbox() {
		driver.findElement(By.xpath("//a[text()='Data Structures']")).click();
	}

	public void click_tryhere_with_timeout(WebDriver driver, int timeout) {
		Actions action = new Actions(driver);
		action.scrollToElement(btn_tryHere);
		btn_tryHere.click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

		
	}

	public void try_python_script(WebDriver driver, String pythontext) {
		try {
			WebElement editsheet = driver.findElement(By.xpath("//div[@class='input']/div/div/textarea"));
			editsheet.sendKeys(pythontext);
			Run.click();
			if (isAlertPresent(driver)) {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert Text: " + alertText);
				alert.accept(); // Handle the alert

			} else {
				// If no alert is present, proceed with further actions
				System.out.println("No alert was present.");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

				String output = text_output.getText();
				System.out.println("Python code executed!! Output : " + output);
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

// Method to check if alert is present
	private boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void Signout() {
		Signout.click();
	}

}
