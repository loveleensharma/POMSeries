package com.qa.hubspot.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {

	public ChromeOptions co;
	public FirefoxOptions fo;
	Properties prop;
	
	public OptionManager(Properties prop) {
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
		//co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		return co;
	}
	public void getFirefoxOptions() {
		fo= new FirefoxOptions();
		fo.addArguments("--headless");
	}
	
}
