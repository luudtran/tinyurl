package hello;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TinyURLTest {
	TinyURL tinyUrl = null;
	String id = null;
	URL target = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		id = "abc";
		target = new URL("http://test.com");
		tinyUrl = new TinyURL(id, target);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTinyURL() {
		assertNotNull(tinyUrl);
	}

	@Test
	public void testGetId() {
		assertEquals(id, tinyUrl.getId());
	}

	@Test
	public void testGetTarget() {
		assertEquals(target, tinyUrl.getTarget());
	}

}
