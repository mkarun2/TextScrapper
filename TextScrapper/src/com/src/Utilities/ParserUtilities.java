package com.src.Utilities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParserUtilities {

	public  Document createDOMDocument(String strURL){
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
