package com.qaprosoft.carina.APItest;

import java.lang.invoke.MethodHandles;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.api.photo.DeletePhotoMethod;
import com.qaprosoft.carina.demo.api.photo.GetPhotoMethods;
import com.qaprosoft.carina.demo.api.photo.PostPhotoMethod;

public class APISampleTestPhoto extends AbstractAPITest implements IAbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testCreatePhoto() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostPhotoMethod api = new PostPhotoMethod();
		api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		api.callAPI();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testGetPhoto() {
		GetPhotoMethods getPhotoMethods = new GetPhotoMethods();
		getPhotoMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
		getPhotoMethods.callAPI();
		getPhotoMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getPhotoMethods.validateResponseAgainstSchema("api/photos/_get/rs.schema");
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	@TestPriority(Priority.P1)
	public void testDeletePhoto() {
		DeletePhotoMethod deletePhotoMethod = new DeletePhotoMethod();
		deletePhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		deletePhotoMethod.callAPI();
		deletePhotoMethod.validateResponse();
	}

}