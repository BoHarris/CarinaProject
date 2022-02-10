package com.qaprosoft.carina.demo.gui.pages.gsmarena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.Constance;

public class GSMArenaSony extends AbstractPage implements Constance {
	@FindBy(xpath = "//div[contains(@class, 'makers')]/ul/li[6]/a")
	private ExtendedWebElement xperiaProLink;

	@FindBy(xpath = "//div[contains(@class, 'makers')]/ul/li[12]/a")
	private ExtendedWebElement XperiaOneLink;

	@FindBy(xpath = "//div[contains(@class, 'makers')]/ul/li[11]/a")
	private ExtendedWebElement XperiaFive;

	public GSMArenaSony(WebDriver driver) {
		super(driver);
	}

	public GSMArenaPhonePage getXperiaPro() {

		xperiaProLink.click();

		return new GSMArenaPhonePage(driver);

	}

	public GSMArenaPhonePage getXperiaOne() {

		XperiaOneLink.click();

		return new GSMArenaPhonePage(driver);

	}

	public GSMArenaPhonePage getXperiaFive() {

		XperiaFive.click();
		return new GSMArenaPhonePage(driver);

	}

}
