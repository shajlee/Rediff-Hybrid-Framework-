package com.qa.practicerediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.practicerediff.base.PracticeRediff_TestBase;
import com.qa.practicerediff.pages.LinkTestsPage;

public class RediffPractice_LinkTests extends PracticeRediff_TestBase {
	public RediffPractice_LinkTests() throws Exception {
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
	public void rediffLinks() {
		
		LinkTestsPage linkTestsPage = new LinkTestsPage(driver);
		linkTestsPage.clickOnRediffMail();
		softassert.assertTrue(linkTestsPage.rediffLogoIsDisplayed(), "rediffLogo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
		linkTestsPage.clickOnRediffMoney();
		softassert.assertTrue(linkTestsPage.rediffMoneyWizLogoIsDisplayed(), "rediffMoneyWizLogo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
		linkTestsPage.clickOnRediffBusinessEmail();
		softassert.assertTrue(linkTestsPage.rediffBusinessMailLogoIsDisplayed(), "businessMailLogo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
		linkTestsPage.clickOnRediffVideos();
		softassert.assertTrue(linkTestsPage.rediffVideoLogoIsDisplayed(), "rediffVideoLogo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
		
		linkTestsPage.clickOnRediffShopping();
		softassert.assertTrue(linkTestsPage.rediffShoppinLogoIsDisplayed(), "rediffShoppingLogo is not displayed");
		softassert.assertAll();
		driver.navigate().back();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
				
				
		
		
		
	}

}
