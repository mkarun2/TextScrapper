package com.test.UtilityTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.src.Utilities.ParserUtilities;
import com.src.Utilities.URLUtilities;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UtilityTest {

	private ParserUtilities puTest;
	private URLUtilities urlTest;
	private String strURLContents;
	
	public void setStrURLContents(String input){
		this.strURLContents = input;
	}
	
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
			this.setStrURLContents(strURLContents);
			assertTrue("URL Contents received",true);
		}else{
			fail("URL Contents not retrieved");
		}
	}
	
	/*
	 * Test if the Document Object Model is
	 * created without excpetion for the 
	 */
	@Test
	public void createDOMDocumentTest() 
			throws MalformedURLException, IOException{
		Document doc = null;
		doc = puTest.createDOMDocument(strURLContents);
		if(doc != null){
			assertTrue("DOM created successfully.",true);
		}else{
			fail("DOM creation failed.");
		}
	}

}
