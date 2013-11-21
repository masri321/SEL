package com.ubc.selenium.eece419project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialTest {
	private String baseUrl;
	private WebDriver driver;
	private ArrayList a1 = new ArrayList();

	String[] array0 = {
			"http://salt.ece.ubc.ca/blog/2013/09/22/feedback-directed-exploration-of-web-applications-to-derive-test-models-issre-13/",
			"http://salt.ece.ubc.ca/publications/amin_issre13.html" };
	
	String[] array1={
			"http://salt.ece.ubc.ca/blog/2013/07/12/best-paper-award-at-icwe-13/",
			"http://salt.ece.ubc.ca/publications/jana_icwe13.html",
			"http://icwe2013.webengineering.org/Contents/Item/Display/257"		
	};
	
	String[] array2={
		"http://salt.ece.ubc.ca/blog/2013/06/25/jsnose-detecting-javascript-code-smells-scam-2013/",
		"http://salt.ece.ubc.ca/publications/amin_scam13.html"	
	};
	String[] array3={
			"http://salt.ece.ubc.ca/blog/2013/05/28/an-empirical-study-of-client-side-javascript-bugs-esem-2013/"
	};
	
	String[] array4={
		"http://salt.ece.ubc.ca/blog/2013/05/28/real-challenges-in-mobile-app-development-esem-2013/"	
	};
	
	String[] array5={
		"http://salt.ece.ubc.ca/blog/2013/04/30/recent-updates/"	
	};
	String[] array6={
		"http://salt.ece.ubc.ca/blog/2013/01/04/icst13/"
	};

	String[] array7={
		"http://salt.ece.ubc.ca/blog/2013/01/02/Octopress/"	
	};

	
	String[][] arrays = new String[][] { array0,array1, array2, array3, array4, array5,array6,array7  };
	@Before
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.get("http://salt.ece.ubc.ca/");

	}

	@After
	public void closeBrowser() {
		driver.close();
	}

	// Test the HomePage of Salt lab
	
	public void Hometest1() throws InterruptedException {

		List<WebElement> entries = driver.findElements(By.tagName("article"));
		for (int i=0;i<entries.size();i++){
			List<WebElement> temps=driver.findElements(By.tagName("article")).get(i).findElements(By.tagName("a"));
			System.out.print(temps.size());
			for(int j=0; j<temps.size();j++){
				driver.findElements(By.tagName("article")).get(i).findElements(By.tagName("a")).get(j).click();
				Thread.sleep(2000);
				assertEquals(arrays[i][j],driver.getCurrentUrl());
				driver.navigate().back();
				Thread.sleep(2000);
			}
			
		}


	}

	
	// Test the Navigation links
		@Test
		public void publicationTest() throws InterruptedException {
			WebElement Mission = driver.findElement(By.linkText("Publications"));
			Mission.click();
			
			List<WebElement> temps=driver.findElements(By.linkText("Details"));
			temps.get(0).click();
			Thread.sleep(1000);
			assertEquals("http://salt.ece.ubc.ca/publications/amin_issre13.html", driver.getCurrentUrl());
			driver.navigate().back();
			Thread.sleep(1000);
			
			temps=driver.findElements(By.linkText("Details"));
			temps.get(1).click();
			Thread.sleep(1000);
			assertEquals("http://salt.ece.ubc.ca/publications/shabnam_ase13.html", driver.getCurrentUrl());
			driver.navigate().back();
			Thread.sleep(1000);
		}
		
		
	// Test the Navigation links
	@Test
	public void Simpletest() {
		WebElement Mission = driver.findElement(By.linkText("Mission"));
		Mission.click();
		assertEquals("http://salt.ece.ubc.ca/mission/", driver.getCurrentUrl());
	}

}
