package webelementstest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

public class WebElementsTest {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.treinoautomacao.hol.es/elementsweb.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testInputMyName() throws InterruptedException {
		WebElement txtNome = driver.findElement(By.name("txtbox1"));
		WebElement txtNomeDisabled = driver.findElement(By.name("txtbox2"));
		if (txtNome.isEnabled()) {
		txtNome.sendKeys("Mirceia Freire");
		}
		Thread.sleep(3000);
		assertEquals("O nome não é igual ao esperado!", "Mirceia Freire", txtNome.getAttribute("value").toString());
		assertTrue("O componente deveria estar desabilitado!", !txtNomeDisabled.isEnabled());
	}

	@Test
	public void testClicaOpcaoRadioButton() throws InterruptedException {
		List<WebElement> elementsRadio = driver.findElements(By.name("radioGroup1"));
		
		//elementsRadio.get(2).click();
		//assertTrue(elementsRadio.get(2).isSelected());
		
		for (WebElement e: elementsRadio) {
			System.out.println(e.getAttribute("value").toString());
			if (e.getAttribute("value").equals("Radio Button 3 Selecionado")) {
				Thread.sleep(3000);
				e.click();
				assertTrue(e.isSelected());
				break;
			}
		}
	}
	
	@Test
	public void testClicaOpcaoCheckBox() {
		List<WebElement> elementsCheck = driver.findElements(By.name("chkbox"));
		elementsCheck.get(2).click();
		elementsCheck.get(3).click();
		
		assertTrue(elementsCheck.get(2).isSelected());
		assertTrue(elementsCheck.get(3).isSelected());
		
		//for (WebElement e: elementsCheck) {
		//	assertFalse("Deveria estar selecionado!", e.isSelected());
			
			//if ((e.getAttribute("value").equals("Check Box 3 selecionado")) || (e.getAttribute("value").equals("Check Box 4 selecionado"))) {
			//	System.out.println(e.getAttribute("value").toString());
			//	e.click();
			//	assertTrue(e.isSelected());
			//}
		//}
	}
	
	@Test
	public void testSelecionaDropDownList() throws InterruptedException {
		WebElement dropdownlist = driver.findElement(By.name("dropdownlist"));
		Select listboxelements = new Select(dropdownlist);
		
		List<WebElement> options = listboxelements.getOptions();
		
		options.get(6).click();
		assertTrue(options.get(6).isSelected());
		
		Thread.sleep(5000);	
	}
	
	@Test
	public void testSelecionaDropDownListMultiplosValores() throws InterruptedException {
		WebElement dropdownlist = driver.findElement(By.name("multiselectdropdown"));
		Select listboxelements = new Select(dropdownlist);
		
		if (listboxelements.isMultiple()) {
			listboxelements.selectByIndex(4);
			listboxelements.selectByIndex(7);
			listboxelements.selectByIndex(8);
		}
		
		Thread.sleep(5000);	
		
		List<WebElement> elementosSelecionados = listboxelements.getAllSelectedOptions();
		
		for (WebElement e : elementosSelecionados) {
			System.out.println("Lista Selecionada: " + e.getText());
			
			boolean isSelected = ((e.getText().equals("Item 5"))
					|| (e.getText().equals("Item 8"))
					|| (e.getText().equals("Item 9")));
			
			assertTrue(isSelected);
		}
		listboxelements.deselectAll();
		
		//List<WebElement> options = listboxelements.getOptions();
		
	//	options.get(4).click();
	//	options.get(7).click();
	//	options.get(8).click();	
		
	//	assertTrue(options.get(4).isSelected());
	//	assertTrue(options.get(7).isSelected());
	//	assertTrue(options.get(8).isSelected());
		
	}
	

}
