package com.qa.practicerediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement SignInButton;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement rediffLogo;
	
	public  LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean signInButtonIsDisplayedandEnabled() {
		boolean displayStatus = SignInButton.isDisplayed() && SignInButton.isEnabled();
		return displayStatus;
	}
	public boolean rediffLogoIsDisplayed() {
		boolean displayStatus = rediffLogo.isDisplayed();
		return displayStatus;
	}
	public void signInButtonIsDisplayed() {
		SignInButton.isDisplayed();
	}
	public void rediffLogoIsDisplayed1() {
		rediffLogo.isDisplayed();
		
		
		
		
		
	
		
	}
	
	
	

}
