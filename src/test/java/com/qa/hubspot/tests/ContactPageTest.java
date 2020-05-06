package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.ElementUtil;

public class ContactPageTest {
	WebDriver driver;
	Properties prop;
	ElementUtil elementUtil;
	
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	
	
	@BeforeTest
	public void setup() {
		basepage=new BasePage();
		prop=basepage.init_prop();
		driver=basepage.init_driver(prop);
		loginpage=new LoginPage(driver);
		homepage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		contactpage=homepage.goToContactPage();
		
	}
	@Test
	public void verifyCreateContact() {
		contactpage.createnewcontact("sahilkumar31790@gmail.com", "sahil", "sharma", "cab driver", "788880035");
		
	}

}
