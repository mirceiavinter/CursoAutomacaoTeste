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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class DragAndDrop {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testArrastaComponenteNaTela() throws InterruptedException, IOException {
		File scrFile;
		
		WebElement boxDragOrigem = driver.findElement(By.id("draggable"));
		WebElement boxDropDestino = driver.findElement(By.id("droppable"));
		
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile , new File("C:\\Users\\aluno\\Mirceia\\Screenshot\\screenshot1.png"));
		
		
		assertEquals("O texto não é igual!", "Drag me to my target", boxDragOrigem.getText());
		assertEquals("O texto não é igual!", "Drop here", boxDropDestino.getText());
		
		new Actions(driver).dragAndDrop(boxDragOrigem, boxDropDestino).perform();
		
		assertEquals("O texto não é igual!", "Dropped!", boxDropDestino.getText());
		
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile , new File("C:\\Users\\aluno\\Mirceia\\Screenshot\\screenshot2.png"));
	}
}
