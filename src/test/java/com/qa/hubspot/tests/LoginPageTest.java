package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest {
	
	//pre-condition-->Test--> Actual vs Expected--> post step
	//@BeforeTest  -->@Test-->    @Assert      --->@AfterTest
	//Browser,url-->Test google title-->Google vsGoogle-->close Browser
	WebDriver driver;
	Properties prop;
	
	BasePage basepage;
	LoginPage loginpage;
	
	@BeforeTest
	public void setup() {
		basepage=new BasePage();
		prop=basepage.init_prop();
		driver=basepage.init_driver(prop);
		loginpage=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title=loginpage.getLoginPageTitle();
		System.out.println("login page title is: "+title );
		Assert.assertEquals(title, Constants.Login_Page_Title);
	}
	@Test (priority=2)
	public void checkSignUplinkdisplayTest() {
		//loginpage.checkSignUpLink();
		Assert.assertTrue(loginpage.checkSignUpLink());
	}
	@Test(priority=3)
	public void checkshowpassworddisplayTest() {
		Assert.assertTrue(loginpage.checkShowPawwordbutton()); 
	}
	@Test(priority=4)
	public void checkforgetlinkdisplayTest() {
		Assert.assertTrue(loginpage.checkforgetPassworddisplay());
	}
	@Test(priority=5)
	public void checkremembertextdisplayTest() {
		Assert.assertTrue(loginpage.checkremembertextdisplay());
	}
	@Test(priority=6,enabled=false)
	public void clickRemembermecheckBox() {
		Assert.assertTrue(loginpage.clickremembermecheckbox());
		 
	}
	@Test(priority=7)
	public void loginTest() {
		HomePage homepage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homepage.getAccountName(), prop.getProperty("accountname"));
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	
	

}
