package org.openmrs.module.facelist;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.facelist.Service.MultipartService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

/**
 * Tests the MyModuleService class and all of its methods
 **/
public class MyModuleServiceTest extends BaseModuleContextSensitiveTest {
	

	@Test
	public void shouldreturnId() throws Exception {




		initializeInMemoryDatabase();

		executeDataSet("Dataset.xml");
		authenticate();

		MultipartService muiltipartService = Context.getService(MultipartService.class);

		
		Assert.assertEquals( muiltipartService.getMultipart(1).getPatient_ID(),1);
	}
}
