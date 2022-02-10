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
import com.qaprosoft.carina.demo.api.album.DeleteAlbumMethod;
import com.qaprosoft.carina.demo.api.album.GetAlbumMethods;
import com.qaprosoft.carina.demo.api.album.PostAlbumMethod;

public class APISampleTestAlbum extends AbstractAPITest implements IAbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testCreateAlbum() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostAlbumMethod api = new PostAlbumMethod();
		api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		api.callAPI();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testGetAlbum() {
		GetAlbumMethods getAlbumMethods = new GetAlbumMethods();
		getAlbumMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
		getAlbumMethods.callAPI();
		getAlbumMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getAlbumMethods.validateResponseAgainstSchema("api/album/_get/rs.schema");
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	@TestPriority(Priority.P1)
	public void testDeleteAlbum() {
		DeleteAlbumMethod deleteAlbumMethod = new DeleteAlbumMethod();
		deleteAlbumMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		deleteAlbumMethod.callAPI();
		deleteAlbumMethod.validateResponse();
	}

}
