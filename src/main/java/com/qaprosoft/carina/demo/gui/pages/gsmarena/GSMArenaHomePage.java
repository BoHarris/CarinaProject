package com.qaprosoft.carina.demo.gui.pages.gsmarena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.Constance;

public class GSMArenaHomePage extends AbstractPage implements Constance {

	@FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//ul/li[5]/a")
	private ExtendedWebElement sonyLink;

	public GSMArenaHomePage(WebDriver driver) {
		super(driver);
	}

	public GSMArenaSony sonyNavigation() {
		sonyLink.click();
		return new GSMArenaSony(driver);

	}

	@Override
	public void open() {
		super.openURL(GSMARENA_URL);
	}

}