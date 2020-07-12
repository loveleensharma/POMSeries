package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.JavaScriptUtil;
import com.qa.hubspot.utils.TimeUtil;

public class ContactsPage extends BasePage {
	WebDriver driver;
	JavaScriptUtil jsUtil;
	ElementUtil elementUtil;
	
	//1. By locater
	 By createcontact= By.xpath("(//span[text()='Create contact'])[1]");
	 By email=By.xpath("//input[@data-field='email']");
	 By firstName=By.xpath("//input[@data-field='firstname']");
	 By lastName= By.xpath("//input[@data-field='lastname']");
	 By jobTitle= By.xpath("//input[@data-field='jobtitle']");
	 By phoneNumber= By.xpath("//input[@data-field='phone']");
	 By contactSubmit=By.xpath("//button[@data-confirm-button='accept']");
	 By contactsNavigationLink = By.xpath("(//i18n-string[text()='Contacts'])[1]");
	
	//2.Constructor
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil =new ElementUtil(driver);
		jsUtil =new JavaScriptUtil(driver);
		
	}
	
	//Method and Actions
	
	
	public void createnewcontact(String emailid, String firstname, String lastname, String jobtitle, String phone) {
		TimeUtil.shortWait();
		
		driver.findElement(createcontact).click();
		TimeUtil.mediumWait();
		//elementUtil.doSendKeys(locator, value);
		elementUtil.getElement(email).sendKeys(emailid);
		//driver.findElement(email).sendKeys(emailid);
		TimeUtil.shortWait();
		//elementUtil.getElement(firstName).sendKeys(firstname);
		driver.findElement(firstName).sendKeys(firstname);
		TimeUtil.shortWait();
		//elementUtil.getElement(lastName).sendKeys(lastname);
		driver.findElement(lastName).sendKeys(lastname);
		TimeUtil.shortWait();
		//elementUtil.getElement(jobTitle).sendKeys(jobtitle);
		driver.findElement(jobTitle).sendKeys(jobtitle);
		TimeUtil.shortWait();
		//elementUtil.getElement(phoneNumber).sendKeys(phone);
		driver.findElement(phoneNumber).sendKeys(phone);
		TimeUtil.shortWait();
		//elementUtil.getElement(contactSubmit);
		//jsUtil.clickElementbyJS(contactSubmit);
		driver.findElement(contactSubmit).click();
		//String fullName = firstname +" "+lastname;
		//String nameXpath = "(//span[text()='"+fullName+"'])[2]";
		//elementUtil.waitForElementToBePresent(contactsNavigationLink, 30);
		//String contactName = elementUtil.doGetText(By.xpath(nameXpath)).trim();
		TimeUtil.mediumWait();
		elementUtil.doClick(contactsNavigationLink);
		
		//return contactName ;
	}

}
