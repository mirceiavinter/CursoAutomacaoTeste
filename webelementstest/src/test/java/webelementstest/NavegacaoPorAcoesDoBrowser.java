package webelementstest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NavegacaoPorAcoesDoBrowser {

	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.treinoautomacao.hol.es");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testNavegacaoPorAcoesDoBrowser() throws InterruptedException {
		
		WebElement linkCalculadora = driver.findElement(By.linkText("Calculadora"));
		linkCalculadora.click();
		
		assertEquals("O título não é igual ao esperado!", "Desafio Automação Cálculos", driver.getTitle());
		
		Thread.sleep(3000);
		
		WebElement linkLocalizarTable = driver.findElement(By.linkText("Localizar Table"));
		linkLocalizarTable.click();
		
		assertLinkLocalizarTable();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		
		assertHomeIndex();
	
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		
		assertLinkLocalizarTable();
	}
	
	private void assertHomeIndex() {
		assertEquals("O título não é igual ao esperado!", "Treino Automação de Testes", driver.getTitle());	
	}	
	
	private void assertLinkLocalizarTable() {
		assertEquals("O título não é igual ao esperado!", "Trabalhando com tables", driver.getTitle());	
	}	
}
