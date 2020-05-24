package com.sahan.jaxrsapp.tests;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	
	WebDriver driver;
	
	@Test
	public void ChromeTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/jaxrsapp/");
		synchronized (driver) {
			driver.wait(2000);
		}
		driver.findElement(By.id("sample"));
		synchronized (driver) {
			driver.wait(2000);
		}
		//driver.close();//
		driver.quit();
		
	}

}
