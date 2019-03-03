package PageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

	WebDriver driver;
	@FindBy(xpath="//input[@title='Search']")
	WebElement homeGoogleSearch;
	
	@FindBy(xpath="//ul[@role='listbox']//li")
	WebElement homeGoogleSearchList;
	
	String searchString = "wedding";
	
	public GoogleHomePage(WebDriver driver){
		
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Get the searchstring actual size
		public int expectedSize(WebDriver driver){
			
			homeGoogleSearch.clear();
			homeGoogleSearch.sendKeys(searchString);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			/**
			 * Example for Visibility of Elements located by
			 */
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
			return (list.size());

		}
		
		//Get the searchstring actual size
		public int actualSize(WebDriver driver){
			
			int actualSize = 0;
			homeGoogleSearch.clear();
			homeGoogleSearch.sendKeys(searchString);
			
			/**
			 * Example for Visibility of Elements located by
			 */
			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
			
			for(int i = 0 ;i< list.size();i++)
			{				
				if(list.get(i).getText().contains(searchString))
				{
					actualSize += 1;
				}
			}

             return(actualSize);
		}		
		
}
