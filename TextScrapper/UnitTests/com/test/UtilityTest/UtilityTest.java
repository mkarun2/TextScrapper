package com.test.UtilityTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import org.apache.commons.httpclient.URIException;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.src.Utilities.ParserUtilities;
import com.src.Utilities.URLUtilities;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UtilityTest {

	private ParserUtilities puTest;
	private URLUtilities urlTest;
	public String strURLContents;
	

	
	
	@Before
	public void setUp(){
		puTest = new ParserUtilities(); 
		urlTest = new URLUtilities();
	}

	/*
	 * Test if the URL contents are retrieved
	 */
	
	@Test
	public void GetHTMLContentFromURLTest() 
			throws MalformedURLException, IOException {
		strURLContents = urlTest.GetHTMLContentFromURL("http://www.shopping.com/Digital-Cameras/products?CLT=SAS&KW=Digital+Cameras");
		if(strURLContents != null){
			assertTrue("URL Contents received",true);
		}else{
			fail("URL Contents not retrieved");
		}
	}
	
	/*
	 * Test if the Document Object Model is
	 * created without exception for the 
	 */
	@Test
	public void createDOMDocumentTest() 
			throws MalformedURLException, IOException{
		Document doc = null;
		String Url = "http://www.shopping.com/Digital%20Cameras/products?CLT=SAS&KW=Digital%20Cameras";
		doc = puTest.createDOMDocument(Url);
		if(doc != null){
			assertTrue("DOM created successfully.",true);
		}else{
			fail("DOM creation failed.");
		}
	}

	/*
	 * Test for UnknownHost Exception which
	 * is captured by the IOException
	 */
	@Test(expected = IOException.class)
	public void createDOMDocumentExceptionTest() throws NullPointerException, IOException {
		Document doc = null;
		String URL = "http://abc";
		doc = puTest.createDOMDocument(URL);
	}
	
	/*
	 * Test by passing null, 
	 * should not cause exception but
	 * return a DOM as null
	 */
	@Test
	public void createDOMDocumentNULLTest() throws NullPointerException, IOException {
		Document doc = null;
		doc = puTest.createDOMDocument(null);
		if(doc == null){
			assertTrue("NULL test passed", true);
		}else{
			fail("NULL test failed with exception");
		}
	}

	/**
	 * NULL test for building the URL 
	 * after preprocessing
	 * @throws UnsupportedEncodingException 
	 * @throws MalformedURLException 
	 * @throws URIException 
	 */
	@Test
	public void buildURLNULLTest() throws UnsupportedEncodingException, URIException, MalformedURLException{
		String output = urlTest.buildURL(null, null);
		if(output == null){ assertTrue("BuildURLTest passed without exception",true);}
		else{ fail("NULL test for build URL failed"); }
	}
	
	/**
	 * Nomral test for building the URL 
	 * after preprocessing
	 * @throws UnsupportedEncodingException 
	 * @throws MalformedURLException 
	 * @throws URIException 
	 */
	@Test
	public void buildURLNormalTest() throws UnsupportedEncodingException, URIException, MalformedURLException{
		String url = "http://www.shopping.com/Digital%20Cameras/Digital%20Cameras/products~PG-1?CLT=SCH&KW=Digital%20Cameras";
		String output = urlTest.buildURL("Digital Cameras", 1);
		assertEquals("URL built properly",url,output);
	}
	
	/**
	 * Passing null to preprocess the URL search keywords
	 * should not result in any exception
	 */
	@Test
	public void preProcessURLNULLTest(){
		String output = urlTest.preProcessURLKeywords(null);
		if(output == null){ assertTrue("Preprocess URL passed without exception",true);}
		else{ fail("NULL test for preprocess URL failed"); }
	}
	
	/**
	 * Normal preprocess the URL search keywords
	 * remove trail and begin spaces and replace
	 * in between spaces with %20
	 */
	@Test
	public void preProcessURLNormalTest(){
		String output = urlTest.preProcessURLKeywords(" Digital Cameras ");
		assertEquals("URL built properly","Digital Cameras",output);
	}
	
	/**
	 * NULL test for retrieving content
	 * from URL
	 * @throws IOException 
	 */
	@Test
	public void GetHTMLContentFromURLNullTest() throws IOException{
		String output = urlTest.GetHTMLContentFromURL(null);
		if(output == null){ assertTrue("Get HTML Content returned NULL without exception",true);}
		else{ fail("NULL test for getting HTML content from URL failed"); }
	}

	/**
	 * test to check if content is retrieved if
	 * a valid URL is provided
	 * @throws IOException
	 */
	@Test
	public void GetHTMLContentFromURLNormalTest() throws IOException{
		String output = urlTest.GetHTMLContentFromURL("http://www.shopping.com");
		if(output == null){ assertTrue("Get HTML Content returned NULL without exception",false);}
		else{ assertTrue("HTML Content retrieved", true); }
	}
	
}
