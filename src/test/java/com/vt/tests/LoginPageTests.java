package com.vt.tests;

import org.testng.annotations.Test;

import com.vt.driver.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	
	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Login Vaishakh", Keys.ENTER);
	}

}
