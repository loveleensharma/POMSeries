package com.qa.hubspot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	WebDriver driver;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver=driver;
	}
	/*public void flash(WebElement element) {
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0; i<20; i++) {
			changeColor(bgcolor, element);
			changeColor("rgb(0,200,0)", element);
			
			}
		}
	
	public void changeColor(String color, WebElement element) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("argument[0].style.backgroundColor ='"+color+"'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}*/
	public void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 20; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	public void clickElementbyJS(By locoter) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("argument[0].click();", locoter);
	}
	

}
