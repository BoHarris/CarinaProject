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
import com.qaprosoft.carina.demo.api.comment.DeleteCommentMethod;
import com.qaprosoft.carina.demo.api.comment.GetCommentMethods;
import com.qaprosoft.carina.demo.api.comment.PostCommentMethod;

public class APISampleTestComment extends AbstractAPITest implements IAbstractTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testCreateComment() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostCommentMethod api = new PostCommentMethod();
		api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		api.callAPI();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testGetComment() {
		GetCommentMethods getCommentMethods = new GetCommentMethods();
		getCommentMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
		getCommentMethods.callAPI();
		getCommentMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getCommentMethods.validateResponseAgainstSchema("api/comment/_get/rs.schema");
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	@TestPriority(Priority.P1)
	public void testDeleteComment() {
		DeleteCommentMethod deleteCommentMethod = new DeleteCommentMethod();
		deleteCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		deleteCommentMethod.callAPI();
		deleteCommentMethod.validateResponse();
	}

}
