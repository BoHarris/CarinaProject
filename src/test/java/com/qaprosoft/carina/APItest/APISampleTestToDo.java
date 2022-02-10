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
import com.qaprosoft.carina.demo.api.todo.DeleteToDoMethod;
import com.qaprosoft.carina.demo.api.todo.GetToDoMethods;
import com.qaprosoft.carina.demo.api.todo.PostToDoMethod;

/**
 * 
 *
 * @author Bo Harris
 */

public class APISampleTestToDo extends AbstractAPITest implements IAbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testCreateToDo() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostToDoMethod api = new PostToDoMethod();
		api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
		api.callAPI();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	public void testGetToDo() {
		GetToDoMethods getToDoMethods = new GetToDoMethods();
		getToDoMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
		getToDoMethods.callAPI();
		getToDoMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getToDoMethods.validateResponseAgainstSchema("api/todos/_get/rs.schema");
	}

	@Test()
	@MethodOwner(owner = "Bo Harris")
	@TestPriority(Priority.P1)
	public void testDeleteToDo() {
		DeleteToDoMethod deleteToDoMethod = new DeleteToDoMethod();
		deleteToDoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		deleteToDoMethod.callAPI();
		deleteToDoMethod.validateResponse();
	}

}
