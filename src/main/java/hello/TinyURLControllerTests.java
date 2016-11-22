package hello;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;

public class TinyURLControllerTests {
	TinyURLController testTinyURLController = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testTinyURLController = new TinyURLController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTinyURLController() {
		assertNotNull(testTinyURLController);
	}

	@Test
	public void testPostTinyurl() {
		testPostGetTinyurl();
	}

	@Test
	public void testGetTinyurl() {
		testPostGetTinyurl();
	}

	@Test
	public void testPostGetTinyurl() {
		String targetUrl = "http://foo.bar";
		TinyURL tinyUrl = testTinyURLController.postTinyurl(targetUrl);
		assertNotNull(tinyUrl);
		MockHttpServletResponse response = new MockHttpServletResponse();
		testTinyURLController.getTinyurl(tinyUrl.getId(), response);
		assertEquals(targetUrl, response.getRedirectedUrl());
		
	}

	@Test
	public void testGenerateString() {
		Random rng = new Random();
		String str = null;
		str = TinyURLController.generateString(rng, "a", 5);
		assertEquals("aaaaa", str);
		str = TinyURLController.generateString(rng, "abcde", 5);
		for (int i = 0; i < str.length(); i++) {
			assertTrue("abcde".contains(String.valueOf(str.charAt(i))));
		}
	}

}
