package com.test.Business.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.src.TextScraper.Business.TextScraperAbstract;
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

	

}
