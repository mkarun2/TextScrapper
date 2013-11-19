package com.src.TextScraper.Business;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.select.Elements;


public class TextScraperQuery1 extends TextScraperAbstract{
	
	
	// pageNo has default value as 1
	public TextScraperQuery1(){
		super();
	}
	/**
	 * This method is used to query for the searchKeyword
	 * and return the number of results retrieved.
	 * Provides the public interface to the client
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public void executeQuery(String strSearchKeyword,Integer pageNo) 
			throws NullPointerException, MalformedURLException, IOException{
		//no string object
		if(strSearchKeyword == null){ throw new NullPointerException("[ERROR]: Empty search keyword."); }
		
		// Base exit
		if (strSearchKeyword.length() == 0) {
			throw new NullPointerException("[ERROR]: Search Keyword or page number is empty");
		}
		
		super.preProcessSearchKeywords(strSearchKeyword,1);
		this.query1Implementation();		
	}
	
	/**
	 * Implementation logic for query 1
	 * Is private and not visible to client
	 * This method is used to query for the searchKeyword
	 * and return the number of results retrieved
	 */
	private void query1Implementation(){
		
		if(doc == null){ throw new NullPointerException("[ERROR]: DOM creation failed."); }
		
		//Total number of results retrieved
		Elements resultsNo = doc.getElementsByClass("numTotalResults");
		if(resultsNo == null){ throw new NullPointerException("[ERROR]: No results fetched."); }
		
		// Set the total results fetched count by parsing eg. "Results 41 - 80 of 1498"
		String[] arrResultCount = resultsNo.text().toString().split(" ");
		this.setiResultCount(Integer.parseInt(arrResultCount[5]));
	}
	
	
	/**
	 * This method is used to display the result of the query
	 */
	public void displayResult()	throws NullPointerException{		
		Integer iCount = this.getiResultCount();		
		//base return
		if(iCount == null){	throw new NullPointerException("[ERROR]: No results retrieved"); }
		// print the result
		else{ System.out.println("[INFO]: Total Number of results retrieved: " + iCount.toString()); }		
	}
}
