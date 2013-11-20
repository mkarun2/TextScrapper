package com.src.TextScraper.Business;

import java.io.IOException;
import java.net.MalformedURLException;
import com.src.Exceptions.IllegalPageNumberException;


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
		if(strSearchKeyword == null || pageNo == null){ 
			throw new NullPointerException("[ERROR]: Empty search keyword or page number"); }
		
		// Base exit
		if (strSearchKeyword.length() == 0) {
			throw new NullPointerException("[ERROR]: Search Keyword or page number is empty");
		}
		
		// pre process - URLEncoding, Build URL for fetching, Retrieve the Number of results for the query
		try {
			super.preProcess(strSearchKeyword,1);
		} catch (IllegalPageNumberException e) {
			System.out.println(e.getMessage());
		}
		
		//Query1 implementation - Retrieve the total number of results for the query search word
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
		Integer iCount = this.getTotalResultCount();				
		//base return
		if(iCount == null){	throw new NullPointerException("[ERROR]: No results retrieved"); }		
		// print the result
		else{ System.out.println("[INFO]: Total Number of results retrieved: " + iCount.toString()); }	
	}
}
