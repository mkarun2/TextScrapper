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

	// Super Class Constructor
	public TextScraperAbstract(){
		objURLUtilities = new URLUtilities();
		objParserUtilities = new ParserUtilities();
	}
}
