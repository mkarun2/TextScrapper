package com.test.Business.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.src.TextScraper.Business.TextScraperQuery1;

public class TextScraperQuery1Test {

	private TextScraperQuery1 tq1;
	
	@Before
	public void setUp() throws Exception {
		tq1 = new TextScraperQuery1();
	}

	/**
	 * Test for NULL keyword passed
	 * @throws NullPointerException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test(expected = NullPointerException.class)
	public void executeQueryBothNull() throws NullPointerException, MalformedURLException, IOException {
		tq1.executeQuery(null,1);
	}
	
	/**
	 * Test for null page number passed
	 * @throws NullPointerException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test(expected = NullPointerException.class)
	public void executeQueryPageNoNull() throws NullPointerException, MalformedURLException, IOException {
		tq1.executeQuery("kw",null);
	}

	/**
	 * Test the executeQuery implementation for NullPOinterException
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 */
	@Test(expected = NullPointerException.class)
	public void executeQueryNullTest() 
			throws NullPointerException, MalformedURLException, IOException{
		tq1.executeQuery(null, null);		
	}
	
	/**
	 * Test the executeQuery implementation for NullPOinterException
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 */
	@Test(expected = NullPointerException.class)
	public void executeQueryEmptyStringTest() 
			throws NullPointerException, MalformedURLException, IOException{
		tq1.executeQuery("", 1);		
	}
	
	/**
	 * This method should retrieve the count of the result set retrieved
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 */
	@Test
	public void executeQueryFunctionalityTest() 
			throws NullPointerException, MalformedURLException, IOException{
		tq1.executeQuery("Digital Cameras", 1);
		assertEquals("Results retrieved.",1498,tq1.getTotalResultCount().intValue());
	}

}
