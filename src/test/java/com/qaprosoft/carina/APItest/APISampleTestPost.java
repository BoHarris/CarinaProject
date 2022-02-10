/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.qaprosoft.carina.demo.api.post.DeletePostMethod;
import com.qaprosoft.carina.demo.api.post.GetPostMethods;
import com.qaprosoft.carina.demo.api.post.PostPostMethod;

/**
 * 
 *
 * @author Bo Harris
 */
public class APISampleTestPost extends AbstractAPITest implements IAbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testCreatePost() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostPostMethod api = new PostPostMethod();
		api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		api.callAPI();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testGetPost() {
		GetPostMethods getPostMethods = new GetPostMethods();
		getPostMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
		getPostMethods.callAPI();
		getPostMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getPostMethods.validateResponseAgainstSchema("api/posts/_get/rs.schema");
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	@TestPriority(Priority.P1)
	public void testDeletePost() {
		DeletePostMethod deletePostMethod = new DeletePostMethod();
		deletePostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		deletePostMethod.callAPI();
		deletePostMethod.validateResponse();
	}

}
