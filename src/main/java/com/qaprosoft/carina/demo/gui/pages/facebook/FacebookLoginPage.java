package com.qaprosoft.carina.demo.gui.pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.Constance;

public class FacebookLoginPage extends AbstractPage implements Constance {
	@FindBy(id = "email")
	private ExtendedWebElement emailInput;

	@FindBy(id = "pass")
	private ExtendedWebElement passwordInput;

	@FindBy(css = "button")
	private ExtendedWebElement loginButton;

	public FacebookLoginPage(WebDriver driver) {
		super(driver);
	}

	public FacebookErrorPage invalidLogin(String email, String password) {
		emailInput.type(email);
		passwordInput.type(password);
		loginButton.click();
		return new FacebookErrorPage(driver);

	}

	@Override
	public void open() {
		super.openURL(FACEBOOK_URL);
	}

}
