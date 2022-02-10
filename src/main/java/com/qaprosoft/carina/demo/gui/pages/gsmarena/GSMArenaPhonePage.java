package com.qaprosoft.carina.demo.gui.pages.gsmarena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.Constance;

public class GSMArenaPhonePage extends AbstractPage implements Constance {

	@FindBy(xpath = "//*[@id=\"specs-list\"]/table[5]")
	private ExtendedWebElement platformInfo;

	@FindBy(xpath = "//div[@id=\"specs-list\"]/table[6]")
	private ExtendedWebElement memoryInfo;

	@FindBy(xpath = "//div[@id=\"specs-list\"]/table[9]")
	private ExtendedWebElement soundInfo;

	public GSMArenaPhonePage(WebDriver driver) {
		super(driver);
	}

	public String getPlatformInfo() {
		return platformInfo.getText();
	}

	public String getMemoryInfo() {
		return memoryInfo.getText();
	}

	public String getSoundInfo() {
		return soundInfo.getText();
	}

}
