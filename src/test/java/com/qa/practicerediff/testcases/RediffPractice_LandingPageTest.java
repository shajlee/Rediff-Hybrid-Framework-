package com.qa.practicerediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.practicerediff.base.PracticeRediff_TestBase;
import com.qa.practicerediff.pages.LandingPage;

public class RediffPractice_LandingPageTest extends PracticeRediff_TestBase {
	public RediffPractice_LandingPageTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowsewrAndOpenApplication(prop.getProperty("browser1"));
		
	}
	@Test(priority= 1)
	public void validateTitleAndCurrentUrl() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		String actualTitle = prop.getProperty("actualTitle");
		String expectedTitle = driver.getTitle();
		
		String actualCurrentUrl = prop.getProperty("actualCurrentUrl");
		String expectedCurrentUrl = driver.getCurrentUrl();
		
		if(actualTitle.equals(expectedTitle) && actualCurrentUrl.equals(expectedCurrentUrl)) {
			System.out.println("Landing Page Is Valid");
		}else {
			System.out.println("Landing Page is not Valid");
		}
	}
	@Test(priority = 2)
	public void signInButtonIsDisplayedAndEnabled() {
	   LandingPage landingPage = new LandingPage(driver);
	   landingPage.signInButtonIsDisplayed();
	   //WebElement SignInButton = driver.findElement(By.linkText("Sign in"));
	   softassert.assertTrue(landingPage.signInButtonIsDisplayedandEnabled(), "SignInButton is not displayed or enabled");
	   softassert.assertAll();
	}
	@Test(priority = 3)
	public void rediffLogoDisplayesd() {
		LandingPage landingpage = new LandingPage(driver);
		landingpage.rediffLogoIsDisplayed1();
		//WebElement reddiffLogo = driver.findElement(By.cssSelector("span.hmsprite.logo"));
		softassert.assertTrue(landingpage.rediffLogoIsDisplayed(), "reddiffLogo is not displayed");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		}
		
		
		
	}
	
	


