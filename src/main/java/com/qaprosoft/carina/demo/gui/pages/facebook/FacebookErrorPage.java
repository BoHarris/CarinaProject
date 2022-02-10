package com.qaprosoft.carina.demo.gui.pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class FacebookErrorPage extends AbstractPage {

	@FindBy(xpath = "//div[@id=\"email_container\"]/div[2]")
	private ExtendedWebElement errorText;

	public FacebookErrorPage(WebDriver driver) {
		super(driver);
	}

	public String getErrorMessage() {
		return errorText.getText();
	}
}
