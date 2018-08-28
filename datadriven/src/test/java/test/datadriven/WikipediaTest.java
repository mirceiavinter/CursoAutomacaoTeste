package test.datadriven;

import org.testng.annotations.Test;

import com.utils.SpreadsheetData;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class WikipediaTest {
	
	public WebDriver driver;

  @Test(dataProvider = "dbPaises")
  public void testDataDrivenExcel(String nome) {
	  driver.findElement(By.name("search")).clear();
	  driver.findElement(By.name("search")).sendKeys(nome);
	  driver.findElement(By.name("go")).click();
	  
	  String tituloPesquisa = driver.findElement(By.id("firstHeading")).getText();
	  assertTrue(nome.equals(tituloPesquisa.trim()));
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider (name = "dbPaises")
  public Object[][] createData() {
	Object[][] testData = SpreadsheetData.readExcelData("Paises","db/paises.xls","Dados");
    return testData;
  }
}
