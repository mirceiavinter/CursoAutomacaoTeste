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

public class ExpressoesRegulares {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.geradordecpf.org/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testValidaMascaraEDigitosCPF() throws InterruptedException {
		
		driver.findElement(By.id("cbPontos")).click();
		driver.findElement(By.id("btn-gerar-cpf")).click();
		
		WebElement cpf = driver.findElement(By.id("numero"));
		String numeroCPF = cpf.getAttribute("value");
		
		System.out.println(numeroCPF);
		
		Thread.sleep(3000);
		
		boolean validaCpf = numeroCPF.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$");
		
		assertTrue(validaCpf);
	}

}
