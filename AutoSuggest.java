import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
 
public class AutoSuggest {
 
	@Test(description="Auto Suggest")
	public void selectValues()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@title='search']")).sendKeys("wedding");
		int totalExpectedSize, totalActualSize ;
		/**
		 * Example for Visibility of Elements located by
		 */
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		totalExpectedSize = 0
		for(int i = 0 ;i< list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().contains("wedding"))
			{
				totalExpectedSize += 1;
			}
		}
		
   totalActualSize = list.size() - 1;
	 Assert.assertEquals( totalExpectedSize, totalActualSize )
		
	}
	
}
