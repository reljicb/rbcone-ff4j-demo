package com.rbc.rbcone.rest;

import javax.servlet.http.HttpServletRequest;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{

	@Autowired
	FF4j ff4j;

	@RequestMapping(value = "/test",
	      method = RequestMethod.GET,
	      produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> get(final HttpServletRequest request)
	{

		return ResponseEntity.ok("hello world - f1 status: " + (ff4j.check("f1") ? "ok" : "off"));
	}

//	@Test
//	public void myFirstFF4JTest()
//	{
//		FF4j ff4j = new FF4j("ff4j.xml");
//		assertEquals(2, ff4j.getFeatures().size());
//		assertTrue(ff4j.exist("sayHello"));
//		assertTrue(ff4j.check("sayHello"));
//		assertTrue(ff4j.check("sayGoodBye"));
//		// Test value at runtime
//
//		if (ff4j.check("sayHello"))
//		{
//			// Feature ok !
//			System.out.println("Hello World !");
//		}
//		else
//		{
//			fail();
//		}
//
//		if (ff4j.check("sayGoodBye"))
//		{
//			// Feature ok !
//			System.out.println("goodbye!");
//		}
//	}
//
//	@Test
//	public void autoCreateFeatureEnableTest()
//	{
//		// Default : store = inMemory, load features from ff4j.xml file
//		FF4j ff4j = new FF4j("ff4j.xml");
//		try
//		{
//			ff4j.check("autoCreatedFeature");
//			fail(); // error is Expected here
//		}
//		catch (FeatureNotFoundException fnfe)
//		{
//			System.out.println("Standard behaviour");
//		}
//
//		ff4j.dis
//		
//		// Change default behavior
//		ff4j.autoCreate(true);
//		if (!ff4j.check("autoCreatedFeature"))
//		{
//			System.out.println("Not available but code won't failed, feature created");
//			assertTrue(ff4j.exist("autoCreatedFeature"));
//			assertFalse(ff4j.check("autoCreatedFeature"));
//		}
//		else
//		{
//			fail();
//		}
//	}
//
//	@Test
//	public void createFeatureDynamically()
//	{ // Initialize with empty store
//		FF4j ff4j = new FF4j();
//		// Dynamically register new features
//		ff4j.create("f1").enable("f1");
//		// Testing
//		assertTrue(ff4j.exist("f1"));
//		assertTrue(ff4j.check("f1"));
//	}
//
}
