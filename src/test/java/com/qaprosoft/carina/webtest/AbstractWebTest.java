package com.qaprosoft.carina.webtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

public abstract class AbstractWebTest implements IAbstractTest {

	protected WebDriver getWebDriver(String browser) {
		WebDriver wd = null;
		switch (browser) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\dev\\ChromeDriver\\chromedriver.exe");
			wd = new ChromeDriver();
			break;
		case "safari":// ↓↓↓ not installed here for demo purposes ↓↓↓↓
			wd = new SafariDriver();
			break;
		case "firefox":
			wd = new FirefoxDriver();
			break;
		case "edge":
			wd = new EdgeDriver();
			break; // ↑↑↑ not installed here for demo purposes ↑↑↑↑
		case "internetexplorer":
			wd = new InternetExplorerDriver();
			break;
		default:
			throw new RuntimeException("Unsupported broswer" + " " + browser);
		}

		return wd;

	}
}
