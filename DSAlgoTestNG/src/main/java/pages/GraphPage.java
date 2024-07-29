package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GraphPage {
	 WebDriver driver;
	  @FindBy(xpath="//a[text()='Graph']")WebElement GraphOptions;
	  @FindBy(xpath="/html/body/div[3]/div[7]/div/div/a")WebElement GetStarted;
	  @FindBy(xpath="//div/ul[2]/a[text()='Graph']")WebElement Graph;
	  @FindBy(xpath="//a[text()='Graph Representations']") WebElement GraphRepresentations ;
   
	// Constructor
	   public GraphPage(WebDriver driver) {
	       this.driver = driver;
	       PageFactory.initElements(driver,this);
	   }
			
		 public void GraphOptions() {
			 GraphOptions.click();
		 }
		 public void GetStarted() {
			    if(GetStarted.isDisplayed()&&GetStarted.isEnabled())
			    {
			    GetStarted.click();
			    }
		 }

		 public void Graph(WebDriver driver, int timeout) {
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
               
		        try {
		        

		            // Wait until the element is visible and clickable
		           
		            WebElement Graph = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul[2]/a[text()='Graph']")));

		            // Now you can interact with the element
		            Graph.click(); // Example action

		        } catch (Exception e) {
		            e.printStackTrace();

		        }
		    }

		 public void GraphRepresentations() {
			 GraphRepresentations.click();

		 }


}
