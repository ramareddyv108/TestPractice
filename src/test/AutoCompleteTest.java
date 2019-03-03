package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.GoogleHomePage;




public class AutoCompleteTest {

	WebDriver driver;
	GoogleHomePage objHomePage;
	private static ChromeDriverService service;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rama/git/TestPracticeOne/src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com/");
	}

	/**
	 * This test go to http://www.google.com
	 * Verify Google.com with search string wedding, and list must have all entries with wedding 
	 * in the text of the list.
	 */
	
	@Test(priority=0)
	public void test_Google_Search_Auto_Complete(){
		//Create GoogleHomePage Object
	objHomePage = new GoogleHomePage(driver);
	//Verify search string present in the list
	int expectedSize = objHomePage.expectedSize(driver);
	int actualSize = objHomePage.actualSize(driver);
	Assert.assertEquals(expectedSize, actualSize);
	}
	
}
