package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest extends BasePage{

	public LoginPageTest() {
		super();
	}
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(2000);
		loginPage = new LoginPage();
	}
	
	@Test(priority = 0)
	public void verifyLoginPageTitle() {
		String LoginTitle = loginPage.LoginPageTitle();
		Assert.assertEquals(LoginTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		
	}
	@Test(priority = 1)
	public void VerifyReturnLinkTest() throws InterruptedException {
		loginPage.VerifyReturnLink();
		Thread.sleep(2000);
		String returnTitle = driver.getTitle();
		Assert.assertEquals(returnTitle, "Return Policy - Flipkart.com");
	}
	
	@Test(priority = 2)
	public void VerifyHomeDropdownListTest() throws InterruptedException {
		loginPage.VerifyHomeDropdownList();
	}
	
	@Test(priority = 3)
	public void searchBoxItemTest() throws InterruptedException {
		loginPage.searchBoxItem();
	}
	
	@Test(priority = 4)
	public void doLoginTest() throws InterruptedException {
		homePage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
