package com.vt.tests;

import org.testng.annotations.Test;

import com.vt.driver.DriverManager;

import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	
	@Test
	public void test1_login() {
		Assert.isTrue(false, null, null);
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Login Vaishakh", Keys.ENTER);
	}
	
	@Test
	public void test1Sample() {
		Assert.isTrue(false, null, null);
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Login Vaishakh", Keys.ENTER);
	}
	
	@Test
	public void test2Sample() {
		Assert.isTrue(false, null, null);
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Login Vaishakh", Keys.ENTER);
	}

}
