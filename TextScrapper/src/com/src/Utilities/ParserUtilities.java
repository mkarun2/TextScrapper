package com.src.Utilities;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParserUtilities {

	/**
	 * Create a Document Object Model for the URL entered
	 * after parsing its web content 
	 * @param strURL
	 * @return Document
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public  Document createDOMDocument(String strURL) throws MalformedURLException, IOException{
		Document doc = null;
		if(strURL != null){
			//get the URL Contents as a String
			String strHTML = new URLUtilities().GetHTMLContentFromURL(strURL);
			
			//Create a DOM Object using JSoup with the strHTML
			doc = Jsoup.parse(strHTML);
		}
		return doc;		
	}	
}
