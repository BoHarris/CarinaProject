package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.utils.Configuration;

public interface Constance {
	String FACEBOOK_URL = Configuration.getEnvArg("facebookURL");
	String GSMARENA_URL = Configuration.getEnvArg("base");
	String CHROME_DRIVER = Configuration.getEnvArg("browserName");

}
