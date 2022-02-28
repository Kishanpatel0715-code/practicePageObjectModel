package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	//page objects
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement LoginBtn;
	
	@FindBy(linkText = "Return Policy")
	WebElement returnLink;
	
	@FindBy(xpath = "(//div[@class='xtXmba'])[6]")
	WebElement HomeDropdownLink;
	
	@FindBy(name="q")
	WebElement searchBox;
	
	@FindBy(xpath = "(//div[@class='IiD88i _351hSN']/input)[1]")
	WebElement email;
	
	@FindBy(xpath = "(//div[@class='IiD88i _351hSN']/input)[2]")
	WebElement password;
	
	@FindBy(xpath = "(//button[@class='_2KpZ6l _2HKlqd _3AWRsL'])[1]")
	WebElement login;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String LoginPageTitle() {
		return driver.getTitle();
	}
	
	public void VerifyReturnLink() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",returnLink );
		returnLink.click();
	}
	
	public void VerifyHomeDropdownList() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(HomeDropdownLink).build().perform();
		Thread.sleep(2000);
		
		List<WebElement> homeLinks = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
		System.out.println(homeLinks.size());
		
		for(WebElement a:homeLinks) {
			System.out.println(a.getText());
		}
	}
	
	public void searchBoxItem() throws InterruptedException {
		String s1 = searchBox.getAttribute("placeholder");
		System.out.println(s1);
		Thread.sleep(2000);
		
		searchBox.sendKeys("iphone");
		String s2 = searchBox.getAttribute("value");
		System.out.println(s2);
	}
	
	public HomePage doLogin(String em,String pwd) throws InterruptedException{
		LoginBtn.click();
		Thread.sleep(2000);
		
		email.sendKeys(em);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
		
		
		
	}
}
