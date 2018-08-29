package com.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class WebDriverUtils implements IWebDriver {

	private static WebDriver driver = null;
	static String driverPath = "C:\\Drivers\\";
	
	public static WebDriver getDriver(String browser) {
		
		if (driver == null) {
			
			if (browser.equals(FIREFOX)){
				System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			if (browser.equals(FIREFOX_HEADLESS)){
				System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
		        options.addArguments("--window-size=1200x600");
				driver = new FirefoxDriver(options);
			}

			if (browser.equals(CHROME)) {
				System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe"); 
				driver = new ChromeDriver();
			}
			
			if (browser.equals(CHROME_HEADLESS)){
		        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		       
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--headless");
		        options.addArguments("--window-size=1200x600");
		        driver = new ChromeDriver(options);
			}
			
			if (browser.equals(IE)) {
				System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			if (browser.equals(EDGE)){
				System.setProperty("webdriver.edge.driver", driverPath+"MicrosoftWebDriver.exe"); 
				driver = new EdgeDriver();
			}
			
			//if (browser.equals(SAFARI)) {
			//	SafariOptions options = new SafariOptions();
			//	options.setUseCleanSession(true);
			//	driver = new SafariDriver(options);
			//}
		}
		return driver;
	}
	
	
	/**
	 * Metodo para pegar o valor de alguma propriedade no arquivo de configuracao do Selenium
	 * O caminho e o nome do arquivo pode ser trocados
	 */
	public static String getSeleniumProperties(String name) {
		Properties properties = new Properties();
		String value = null;
		
		try {
		    properties.load(new FileInputStream("src/test/resources/selenium.properties"));
		    value = properties.getProperty(name);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
