package is.gogg.tictactoe;
//package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;


public class FirefoxTestIT {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://goggapp.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testTitle() throws Exception {
		selenium.open("/");
		assertEquals("Tictactoe", selenium.getTitle());
	}
	
	@Test
	public void testMarkerInfo() throws Exception {
		selenium.open("/");
		selenium.type("id=marker", "x");
		selenium.click("css=button.btn.btn-default");
		Thread.sleep(2000);
		assertEquals("You are X", selenium.getText("id=results"));
	}
	
	@Test
	public void testXTurn() throws Exception {
		selenium.open("/");
		selenium.type("id=marker", "x");
		selenium.click("css=button.btn.btn-default");
		selenium.click("id=cell0");
		Thread.sleep(2000);
		assertEquals("X", selenium.getText("id=cell0"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
