package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage open() {
		driver.get("https://pt-br.facebook.com/");
		return this;
	}

	public LoginPage sendEmail(String email) {
		driver.findElement(By.name("email")).sendKeys(email);
		return this;
	}

	public LoginPage sendSenha(String senha) {
		driver.findElement(By.name("pass")).sendKeys(senha);
		return this;
	}
	
	public HomePage logar() {
		driver.findElement(By.id("loginbutton")).click();
		return new HomePage(driver);
	}
	
	public InvalidPage logarSenhaErrada() {
		driver.findElement(By.id("loginbutton")).click();
		return new InvalidPage(driver);
	}

}
