package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends BasePage{

	public HomePageTest() {
		super();
	}
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(2000);
		loginPage = new LoginPage();
		homePage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homeTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority = 2)
	public void verifyMyaccountLinkTest() {
		boolean b = homePage.verifyMyaccountLink();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
