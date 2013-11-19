package com.src.TextScraper.Business;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;

import com.src.Utilities.ParserUtilities;
import com.src.Utilities.URLUtilities;

public abstract class TextScraperAbstract {
	
	protected Integer iResultCount;
	protected Document doc;
	protected URLUtilities objURLUtilities;
	protected ParserUtilities objParserUtilities;
	protected String strSearchKeyword;
	protected Integer iPageNum;
	protected String strURL;
	
	// Abstract Methods
	public abstract void executeQuery(String strKeyword, Integer pageNum) 
			throws NullPointerException,MalformedURLException, IOException;
	public abstract void displayResult();
	
	// Super Class Common Methods
	public Integer getiResultCount() {
		return iResultCount;
	}

	public void setiResultCount(Integer iResultCount) {
		this.iResultCount = iResultCount;
	}
	
	/**
	 * Preprocess the search keywords and build the URL
	 * using the utilities written
	 * @param searchKeyword
	 * @param iPageNum
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public void preProcessSearchKeywords(String searchKeyword, Integer iPageNum) 
			throws MalformedURLException, IOException{
		
		this.strSearchKeyword = searchKeyword;
		this.iPageNum = iPageNum;
		
		// remove beginning and trailing spaces and replace space in between keywords with %20
		String strProcessedCategory = objURLUtilities.preProcessURLKeywords(strSearchKeyword);
		if(strProcessedCategory == null){ throw new NullPointerException("[ERROR]: URL preprocessing failed."); }
		
		// Build the URL
		strURL = objURLUtilities.buildURL(strProcessedCategory,this.iPageNum);		
		if(strURL == null){ throw new NullPointerException("[ERROR]: URL building failed."); }
		
		//URL used for result fetch
		System.out.println("[INFO]: URL: "+strURL);
		
		// Create the DOM
		doc = objParserUtilities.createDOMDocument(strURL);
	}

	// Super Class Constructor
	// initialize everything to be safer, even though instance variables
	// are initialized by default
	public TextScraperAbstract(){
		objURLUtilities = new URLUtilities();
		objParserUtilities = new ParserUtilities();
		doc = null;
		iResultCount = null;
		strSearchKeyword = null;
		iPageNum = null;
		strURL = null;
	}
}
