package com.src.TextScraper.Business;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.select.Elements;


public class TextScraperQuery1 extends TextScraperAbstract{
	
	
	// pageNo is by default 1
	public TextScraperQuery1(){
		super();
	}
	/**
	 * This method is used to query for the searchKeyword
	 * and return the number of results retrieved
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public void executeQuery(String strSearchKeyword,Integer pageNo) 
			throws NullPointerException, MalformedURLException, IOException{
		// Base exit
		if (strSearchKeyword == null || strSearchKeyword.length() == 0 || pageNo == null) {
			throw new NullPointerException("[ERROR]: Search Keyword or page number is empty");
		}
		
		// remove beginning and trailing spaces and replace space in between keywords with %20
		String strProcessedCategory = objURLUtilities.preProcessURLKeywords(strSearchKeyword);
		if(strProcessedCategory == null){ throw new NullPointerException("[ERROR]: URL preprocessing failed."); }
		
		// Build the URL
		String strURL = objURLUtilities.buildURL(strProcessedCategory,pageNo);		
		if(strURL == null){ throw new NullPointerException("[ERROR]: URL building failed."); }
		
		//URL used for result fetch
		System.out.println("[INFO]: URL: "+strURL);
		
		// Create the DOM
		doc = objParserUtilities.createDOMDocument(strURL);
		if(doc == null){ throw new NullPointerException("[ERROR]: DOM creation failed."); }
		
		//Total number of results retrieved
		Elements resultsNo = doc.getElementsByClass("numTotalResults");
		if(resultsNo == null){ throw new NullPointerException("[ERROR]: No results fetched."); }
		
		// Set the total results fetched count by parsing "Results 41 - 80 of 1498"
		String[] arrResultCount = resultsNo.text().toString().split(" ");
		this.setiResultCount(Integer.parseInt(arrResultCount[5]));
	}
	
	/**
	 * This method is used to display the result of the query
	 */
	public void displayResult(){
		Integer iCount = this.getiResultCount();
		
		//base return
		if(iCount == null){
			System.out.println("No reseults retrieved");
			return;
		}else{
			System.out.println("Total Number of results retrieved: " + iCount.toString());
		}
		
	}
}
