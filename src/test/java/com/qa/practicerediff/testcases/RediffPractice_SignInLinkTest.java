package com.qa.practicerediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.practicerediff.base.PracticeRediff_TestBase;
import com.qa.practicerediff.pages.SignInLinkTestPage;

public class RediffPractice_SignInLinkTest extends PracticeRediff_TestBase {
	public RediffPractice_SignInLinkTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowsewrAndOpenApplication(prop.getProperty("browser1"));
	}
	@Test(priority=1)
	public void clickOnSignInLink() {
		SignInLinkTestPage signInLinkTestPage = new SignInLinkTestPage(driver);
		signInLinkTestPage.clickOnSignInLink();
		//driver.findElement(By.linkText("Sign in")).click();
		//WebElement rediffMailLogo = driver.findElement(By.cssSelector("div.logtext"));
		softassert.assertTrue(signInLinkTestPage.rediffMailLogoIsDisplayed(), "rediffMailLogo is not displayed");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	

}
