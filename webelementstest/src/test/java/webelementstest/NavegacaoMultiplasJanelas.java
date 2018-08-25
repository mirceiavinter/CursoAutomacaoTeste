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

public class NavegacaoMultiplasJanelas {

	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.treinoautomacao.hol.es/index.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testNavegacaoMultiplasJanelas() throws InterruptedException {
		
		WebElement linkGragDrop = driver.findElement(By.linkText("Drag and Drop"));
		linkGragDrop.click();
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		assertEquals("O título não é igual ao esperado!", "Mootools Drag and Drop Example", driver.getTitle());
		
		driver.switchTo().window(tabs.get(0));
		
		assertEquals("O título não é igual ao esperado!", "Treino Automação de Testes", driver.getTitle());
	}
	
	
	@Test
	public void testNavegacaoMultiplasJanelas2() throws InterruptedException {
		
		//validar o título da primeira janela
		assertHomeIndex();
		
		WebElement linkGragDrop = driver.findElement(By.linkText("Drag and Drop"));
		linkGragDrop.click();
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//alteração do foco da primeira janela para a segunda janela
		driver.switchTo().window(tabs.get(1));
		//validar foco na segunda janela
		assertDragAndDrop();		
		//alteração do foco da segunda janela para a primeira janela
		driver.switchTo().window(tabs.get(0));
		//validar foco na primeira janela
		assertHomeIndex();
	}	

	private void assertDragAndDrop() {
		assertEquals("O título não é igual ao esperado!", "Mootools Drag and Drop Example", driver.getTitle());
	}

	private void assertHomeIndex() {
		assertEquals("O título não é igual ao esperado!", "Treino Automação de Testes", driver.getTitle());	
	}	
	
}
