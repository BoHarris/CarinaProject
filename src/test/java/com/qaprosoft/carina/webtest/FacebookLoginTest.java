package com.qaprosoft.carina.webtest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.demo.gui.pages.facebook.FacebookErrorPage;
import com.qaprosoft.carina.demo.gui.pages.facebook.FacebookLoginPage;

public class FacebookLoginTest extends AbstractWebTest {

	@Test(dataProvider = "invalidCred")
	public void facebookLoginTest(String TUID, String email, String password) {
		FacebookLoginPage fbLogin = new FacebookLoginPage(getDriver());
		fbLogin.open();
		FacebookErrorPage fbError = fbLogin.invalidLogin(email, password);
		Assert.assertEquals(fbError.getErrorMessage(),
				"The email or mobile number you entered isn’t connected to an account. Find your account and log in.",
				"Error Messages are not equal from TUID " + TUID + "!!!!");
	}

	@DataProvider(parallel = false, name = "invalidCred")
	public static Object[][] dataprovider() {
		return new Object[][] { { "TUIT : Data1", "aewrstgxfdzsaWearwstgdfserste", "adefaraerfgfgdr" },
				{ "TUIT : Data2", "arewafsd", "rewqety" },
				{ "TUIT : Data3", "likuhmjnhyg", "adefaraerkuyjmnhgbffgfgdr" } };
	}

}
