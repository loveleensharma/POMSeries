package com.qa.hubspot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.TimeUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	ContactsPage contactpage;
	
	//1. By locater
	By heading= By.cssSelector("h1.private-page__title");
	By logo=By.xpath("//div[@aria-label='HubSpot Navigation']//*[local-name()='svg']//*[local-name()='g' and @class='cls-2']//*[local-name()='path' and @class='cls-3']");
	By accounticon=By.id("account-menu-container");
	By accountname=By.xpath("//a[@id='navAccount-current']/div[@class='navAccount-accountName']");
	By topmenu=By.xpath("//div[@class='nav-left']//ul[@class='primary-links']/li/a");
	By contactprimarylink=By.xpath("//div[@class='desktop-nav-left-container']//a[@id='nav-primary-contacts-branch']");
	By contactsecondarylink=By.id("nav-secondary-contacts");
	
	
	
	//2. Constructor
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		}
	
	//3. Actions/Methods
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean getLogoHomePage() {
		 boolean logodisplay=driver.findElement(logo).isDisplayed();
		return logodisplay;
	}
	
	public String getHomePageHeader() {
		TimeUtil.mediumWait();
		if(driver.findElement(heading).isDisplayed())
		{
		//return driver.findElement(heading).getText();
			return elementUtil.doGetText(heading);
		}
		return null;
		}
	public String getAccountName() {
		driver.findElement(accounticon).click();
		if(driver.findElement(accountname).isDisplayed()) {
			//return driver.findElement(accountname).getText();
			return elementUtil.doGetText(accountname);
		}
		elementUtil.doClick(accounticon);
		//driver.findElement(accounticon).click();
		return  null;
		}
	public ContactsPage goToContactPage() {
		clickToContact();
		return contactpage=new ContactsPage(driver);
		
		
	}
	public void clickToContact() {
		TimeUtil.shortWait();
		elementUtil.doClick(contactprimarylink);
		elementUtil.doClick(contactsecondarylink);
		//driver.findElement(contactprimarylink).click();
		//driver.findElement(contactsecondarylink).click();
	}
	public void getTopMenulist() {
		List<WebElement> topmenulist=driver.findElements(topmenu);
		System.out.println(topmenulist.size());
		for(int i=0; i<topmenulist.size(); i++) {
			String topmenutext=topmenulist.get(i).getText();
			System.out.println(topmenutext);
			
		}
		
	}
	



}
	
	
	

	

