package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	@FindBy(xpath = "(//div[@class='exehdJ'])[1]")
	WebElement verifyMyAccountLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyMyaccountLink() {
		return verifyMyAccountLink.isDisplayed();
	}
}
