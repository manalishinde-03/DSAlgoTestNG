package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrayPage {

	public WebDriver driver;
	@FindBy(xpath = "//a[text()='Arrays']")
	WebElement Arrayoptions;
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/a")
	WebElement GetStarted;
	@FindBy(xpath = "//a[text()='Arrays in Python']")
	WebElement araaysInPython;
	@FindBy(xpath = "//a[text()='Arrays Using List']")
	WebElement ArraysUsingList;
	@FindBy(xpath = "//a[text()='Basic Operations in Lists']")
	WebElement basicOperationsInList;
	@FindBy(xpath = "//a[text()='Applications of Array']")
	WebElement ApplicationsOfArrays;
	@FindBy(xpath = "//*[text()='Try here>>>']")
	WebElement TryHereButton;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement run;
	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement Signout;

	// Constructor
	public ArrayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void arrayOptions() {

		Arrayoptions.click();
	}

	public void getStarted() {
		GetStarted.click();
	}

	public void araaysInPython() {
		araaysInPython.click();
	}

	public void arraysUsingList() {
		ArraysUsingList.click();

	}

	public void basicOperationsInList() {
		basicOperationsInList.click();

	}

	public void applicationsOfArrays() {
		ApplicationsOfArrays.click();

	}

	public void run() {
		run.click();
	}

}
