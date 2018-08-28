package com.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.page.HomePage;
import com.page.InvalidPage;
import com.page.LoginPage;

public class LoginFacebookTest {

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
		
		loginPage.open();
		loginPage.sendEmail("treinoautomacao01@gmail.com");
		loginPage.sendSenha("teste1000");
		
		HomePage homePage = loginPage.logar();
		assertTrue("Deveria ter logado!", homePage.estaLogado()); 
	}
	
	@Test
	public void testLoginInvalido() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.open();
		loginPage.sendEmail("treinoautomacao01@gmail.com");
		loginPage.sendSenha("senha1000");
		
		InvalidPage invalidPage = loginPage.logarSenhaErrada();
		assertTrue("Não deveria ter logado!", invalidPage.confirmaPerfil()); 
	}
	
	@Test
	public void testPostagemPublicacao() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.open();
		loginPage.sendEmail("treinoautomacao01@gmail.com");
		loginPage.sendSenha("teste1000");
		
		HomePage homePage = loginPage.logar();
		homePage.sendPost("Automation test with WebDriver Rocks - Mirceia!");
		Thread.sleep(5000);
		//assertTrue("Post deveria estar publicado!", homePage.postPublicado()); 
	}
	

}
