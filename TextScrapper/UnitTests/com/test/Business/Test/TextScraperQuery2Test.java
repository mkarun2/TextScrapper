package com.test.Business.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.src.Exceptions.IllegalPageNumberException;
import com.src.TextScraper.Business.TextScraperQuery2;

public class TextScraperQuery2Test {

	private TextScraperQuery2 tq2;
	
	@Before
	public void setUp() throws Exception {
		tq2 = new TextScraperQuery2();
	}

	/**
	 * Test the main functionality of query2 
	 * where a list of products relevant to
	 * the search keyword defined by the user
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 */
	
	@Test
	public void executeQueryFunctionalityTest() 
			throws NullPointerException, MalformedURLException, IOException {
		tq2.executeQuery("Digital Cameras", 2);
		assertEquals("Products Retrieved",40,tq2.getProductList().size());
	}
	
	/**
	 * Test for NullPointerException
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 */
	@Test(expected=NullPointerException.class)
	public void executeQueryExceptionTest() 
			throws NullPointerException, MalformedURLException, IOException {
		tq2.executeQuery(null, 2);
	}
	
	/**
	 * Test for NullPointerException
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 */
	@Test(expected=NullPointerException.class)
	public void executeQueryPageNumExceptionTest() 
			throws NullPointerException, MalformedURLException, IOException {
		tq2.executeQuery("Digital Cameras", null);
	}
	
	/**
	 * Test for invalid page number provided
	 * as input
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 */
	@Test(expected=NullPointerException.class)
	public void executeQueryInvalidPageNumTest() 
			throws IllegalPageNumberException, MalformedURLException, IOException {
		tq2.executeQuery("DigitalCameras", 41);
	}
	
	/**
	 * Test for malformed URL with special Characters
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 */
	@Test(expected=IOException.class)
	public void executeQueryInvalidSearchKeywordExceptionTest() 
			throws NullPointerException, MalformedURLException, IOException {
		tq2.executeQuery("Asdasdasds$%#$%",41);
	}

}