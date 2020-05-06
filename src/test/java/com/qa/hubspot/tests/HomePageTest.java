package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ReporterConfig.Property;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	
	
	WebDriver driver;
	Properties prop;
	
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeTest
	
	public void setup() {
		basepage=new BasePage();
		prop=basepage.init_prop();
		driver=basepage.init_driver(prop);
		loginpage=new LoginPage(driver);
		homepage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@Test (priority=1)
	public void verifyHomePageTitleTest() {
		//homepage.getHomePageTitle();
		Assert.assertEquals(homepage.getHomePageTitle(), Constants.Home_page_Title);
	}
	/*@Test  (priority=3)
	public void verifyLogoHomePageTest() {
		Assert.assertFalse(condition, message);(homepage.getLogoHomePage());
		//Assert.assertFalse(false);
	}*/
	@Test (priority=2)
	public void verifyHomePageHeaderTest() {
		//homepage.getHomePageHeader();
		Assert.assertEquals(homepage.getHomePageHeader(), Constants.Home_page_Heading);
	}
	@Test(priority=3, enabled=false)
	public void verfiyTopMenuText() {
		homepage.getTopMenulist();
	}
	@Test (priority=4)
	public void verifyAccountUserTest() {
		//homepage.getAccountName();
		Assert.assertEquals(homepage.getAccountName(), prop.getProperty("accountname"));
	}
	/*@AfterTest
	public void tearDown() {
		driver.quit();
	}*/
	

}
