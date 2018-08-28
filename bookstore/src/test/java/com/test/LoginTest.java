package com.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.page.HomePage;
import com.page.LoginPage;

public class LoginTest {
	
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testLoginValido() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.open()
				.sendUser("test")
				.sendPassword("secret")
				.logar();
		
		assertTrue("Deveria ter logado!", homePage.isLogged()); 
		
		//assertTrue(new LoginPage(driver).open().sendUser("test").sendPassword("secret").logar().isLogged());
	}
	
	@Test
	public void testLoginValido_old() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		loginPage.sendUser("test");
		loginPage.sendPassword("secret");
		
		HomePage homePage = loginPage.logar();
		assertTrue("Deveria ter logado!", homePage.isLogged()); 
	}
	
}
