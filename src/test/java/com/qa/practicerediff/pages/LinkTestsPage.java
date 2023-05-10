package com.qa.practicerediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkTestsPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Rediffmail")
	private WebElement rediffMail;
	
	@FindBy(className = "logtext")
	private WebElement rediffLogo;
	
	@FindBy(linkText = "Money")
	private WebElement money;
	
	@FindBy(linkText = "Rediff Moneywiz")
	private WebElement rediffMoneyWizLogo;
	
	@FindBy(linkText = "Business Email")
	private WebElement businessEmail;
	
	@FindBy(className = "logo")
	private WebElement rediffBusinessMailLogo;
	
	@FindBy(linkText = "Videos")
	private WebElement videos;
	
	@FindBy(css = "img.othersprite.isharelogo")
	private WebElement rediffVideoLogo;
	
	@FindBy(linkText = "Shopping")
	private WebElement shopping;
	
	@FindBy(css = "img.shsprite.shoptoplogo")
	private WebElement rediffShoppingLogo;
	
	public LinkTestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnRediffMail() {
		rediffMail.click();
	}
	public void clickOnRediffMoney() {
		money.click();
	}
	public void clickOnRediffBusinessEmail() {
		businessEmail.click();
	}
	public void clickOnRediffVideos() {
		videos.click();
	}
	public void clickOnRediffShopping() {
		shopping.click();
	}
	public boolean rediffLogoIsDisplayed() {
		boolean logo = rediffLogo.isDisplayed();
		return logo;
	}
	public boolean rediffMoneyWizLogoIsDisplayed() {
		boolean moneylogo = rediffMoneyWizLogo.isDisplayed();
		return moneylogo;
	}
	public boolean rediffBusinessMailLogoIsDisplayed() {
		boolean businesslogo = rediffBusinessMailLogo.isDisplayed();
		return businesslogo;
	}
	public boolean rediffShoppinLogoIsDisplayed() {
		boolean shoppinglogo = rediffShoppingLogo.isDisplayed();
		return shoppinglogo;
	}
	public boolean rediffVideoLogoIsDisplayed() {
		boolean videologo = rediffVideoLogo.isDisplayed();
		return videologo;
	}
    
}
