package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.TimeUtil;

public class LoginPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	//.1.By locater
	
	By email= By.id("username");
	By password=By.id("password");
	By loginbtn=By.id("loginBtn");
	By signuplink=By.linkText("Sign up");
	By showpassword=By.xpath("//span[text()='Show Password']//parent::button");
	By forgetpassword=By.xpath("//i18n-string[text()='Forgot my password']");
	By remembermetext=By.xpath("//i18n-string[text()='Remember me']");
	By remembercheckbox=By.id("remember");
	
	
	
	
	//2. Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3.Page Actions and method
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean checkSignUpLink() {
		boolean signlink =driver.findElement(signuplink).isDisplayed();
		return signlink;
	}
	public boolean checkShowPawwordbutton() {
		boolean showpwdbtb=driver.findElement(showpassword).isDisplayed();
		return showpwdbtb;
	}
	public boolean checkforgetPassworddisplay() {
		boolean forgetlink =driver.findElement(forgetpassword).isDisplayed();
		return forgetlink;
	}
	public boolean checkremembertextdisplay() {
		boolean remembertext=driver.findElement(remembermetext).isDisplayed();
		return remembertext;
	}
	public boolean clickremembermecheckbox() {
		boolean checkbox =driver.findElement(remembercheckbox).isSelected();
		if(checkbox ==false) {
			driver.findElement(remembercheckbox).click();
		}
		return checkbox;
		
		
	}
	public HomePage dologin(String un, String pwd) {
		//elementUtil.getElement(email).sendKeys(un);
		//driver.findElement(email).sendKeys(un);
		//driver.findElement(password).sendKeys(pwd);
		//driver.findElement(loginbtn).click();
		elementUtil.doSendKeys(email, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginbtn);
		TimeUtil.mediumWait();
		return new HomePage(driver);
		
		}
	

}
