package com.qa.hubspot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	
	public WebElement getElement(By locater) {
		WebElement element=driver.findElement(locater);
		jsUtil.flash(element);
		return element;
	}
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locater) {
		getElement(locater).click();
	}
	public String doGetText(By locater) {
		return getElement(locater).getText();
	}
	public WebElement waitForElementToBePresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
	}
	

}
