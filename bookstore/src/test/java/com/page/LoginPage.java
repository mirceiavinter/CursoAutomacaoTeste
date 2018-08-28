package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage open() {
		driver.get("http://sahitest.com/demo/training/login.htm");
		return this;
	}

	public LoginPage sendUser(String userName) {
		driver.findElement(By.name("user")).sendKeys(userName);
		return this;		
	}

	public LoginPage sendPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
		return this;		
	}

	public HomePage logar() {
		driver.findElement(By.cssSelector(".button")).click();
		return new HomePage(driver);
	}
	
	

}
