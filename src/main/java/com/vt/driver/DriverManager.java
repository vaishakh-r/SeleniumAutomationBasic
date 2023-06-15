package com.vt.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private DriverManager() {
		
	}
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDriver(WebDriver webdriverRef) {
		dr.set(webdriverRef);
	}
	
	public static void unload() {
		dr.remove();
	}
	

}
