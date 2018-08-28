package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;		
	}

	public boolean isLogged() {
		return driver.findElement(By.cssSelector("#available>h2")).isDisplayed();
	}

}
