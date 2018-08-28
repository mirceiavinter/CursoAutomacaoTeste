package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;	
	}

	public boolean estaLogado() {
		return driver.findElement(By.id("u_0_c")).isDisplayed();
	}
	
	public HomePage sendPost(String publicacaoPost) {
		driver.findElement(By.name("xhpc_message")).sendKeys(publicacaoPost);
		driver.findElement(By.xpath("//*/span[@value='1'")).click();
		return this;
	}
	
	public boolean postPublicado() {
		return driver.findElement(By.xpath("//*[text()='Automation test with WebDriver Rocks - Mirceia!']")).isDisplayed();
	}	
}
