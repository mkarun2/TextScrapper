package com.src.TextScraper.Business;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.src.Exceptions.IllegalPageNumberException;
import com.src.Utilities.ParserUtilities;
import com.src.Utilities.URLUtilities;

public abstract class TextScraperAbstract {
	
	protected Integer iResultCount;
	protected Integer totalResultCount;
	protected Document doc;
	protected URLUtilities objURLUtilities;
	protected ParserUtilities objParserUtilities;
	protected String strSearchKeyword;
	protected Integer iPageNum;
	protected String strURL;
	
	// Abstract Methods
	protected abstract void executeQuery(String strKeyword, Integer pageNum) 
			throws NullPointerException,MalformedURLException, IOException;
	
	// Super Class Common Methods
	public Integer getiResultCount() {
		return iResultCount;
	}

	public void setiResultCount(Integer iResultCount) {
		this.iResultCount = iResultCount;
	}
	
	public Integer getTotalResultCount() {
		return totalResultCount;
	}
	public void setTotalResultCount(Integer totalResultCount) {
		this.totalResultCount = totalResultCount;
	}
	
	
	/**
	 * Preprocess the search keywords and build the URL
	 * and obtain the search result set count
	 * which can be used by the child classes
	 * using the utilities written
	 * @param searchKeyword
	 * @param iPageNum
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws IllegalPageNumberException 
	 */
	protected void preProcess(String searchKeyword, Integer iPageNum) 
			throws MalformedURLException, IOException, IllegalPageNumberException{
		
		this.strSearchKeyword = searchKeyword;
		this.iPageNum = iPageNum;
		
		// Build the URL
		strURL = objURLUtilities.buildURL(searchKeyword,this.iPageNum);		
		if(strURL == null){ throw new NullPointerException("[ERROR]: URL building failed."); }
		
		//URL used for result fetch
		System.out.println("[INFO]: URL: "+strURL);
		
		// Create the DOM
		doc = objParserUtilities.createDOMDocument(strURL);		
		if(doc == null){ throw new NullPointerException("[ERROR]: DOM creation failed."); }
		
		//Total number of results retrieved
		Elements resultsNo = doc.getElementsByClass("numTotalResults");
		if(resultsNo == null || resultsNo.size() == 0){ throw new NullPointerException("[INFO]: No results fetched. Please check your page number"); }
		
		// get the total results fetched count by parsing string "Results 41 - 80 of 1498"		
		String[] arrResultCount = resultsNo.text().toString().split(" ");
		
		// Results count viewed so far in the output eg: 80 results in 2 pages, so count = 80
		int totalPageResultsCount = Integer.parseInt(objURLUtilities.removeComma(arrResultCount[3]));	
		this.setiResultCount(totalPageResultsCount);
		
		 // total result set count
		this.setTotalResultCount(Integer.parseInt(objURLUtilities.removeComma(arrResultCount[5])));
		
		// calculate the total number of pages 
		Double totalPages = Math.ceil(this.getTotalResultCount()/40);
		
		// check for valid page range entered by the user
		if(this.iPageNum < 0 || this.iPageNum > totalPages){
			throw new IllegalPageNumberException("Page number can only be between 1 and " + totalPages.toString());
		}
	}

	// Super Class Constructor
	// initialize everything to be safer, even though instance variables are initialized by default
	protected TextScraperAbstract(){
		objURLUtilities = new URLUtilities();
		objParserUtilities = new ParserUtilities();
		doc = null;
		iResultCount = null;
		strSearchKeyword = null;
		iPageNum = null;
		strURL = null;
	}
}
