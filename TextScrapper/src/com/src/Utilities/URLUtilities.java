package com.src.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLUtilities {

	/**
	 * GetHTMLContentFromURL is used to parse return the viewSource(HTML
	 * content) of the strURL, a web page URL
	 * 
	 * @param strURL
	 * @return
	 * @throws MalformedURLException 
	 */
	public String GetHTMLContentFromURL(String strURL) 
			throws MalformedURLException,IOException {
		URL url = null;
		URLConnection urlConnection = null;
		BufferedReader buffReader = null;
		String strInputLine = null;
		StringBuilder sbHTMLContent = null;

		// Convert from string URL to URL type
		url = new URL(strURL.trim());

		// open the URL Connection to open the web page
		urlConnection = url.openConnection();

		// Initialize a buffered Reader to read the contents through the Input
		// Stream
		// The encoding assumed here is UTF-8 since it is the most prevalent in
		// recent application
		buffReader = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream(), "UTF-8"));
		sbHTMLContent = new StringBuilder();

		// read the contents line by line and add to String Builder object which
		// does not
		// cause immutable strings and saves space
		while ((strInputLine = buffReader.readLine()) != null) {
			sbHTMLContent.append(strInputLine + "\n");
		}
		buffReader.close();
		if (sbHTMLContent != null) {
			return sbHTMLContent.toString(); // return a single string of the
												// HTML contents
		}
		// this point is reached if the HTML Content is empty
		return null;
	}

	/**
	 * This method is used to pre-process the URL for the following 1) replace
	 * ' ' (space) with '%20' 2) Trim extra spaces in the keywords as the user
	 * may leave extra spaces at the end or at the beginning of the search
	 * keywords
	 * 
	 * @param strKeyword
	 *            - keyword to pre process
	 * @return
	 */
	public String preProcessURLKeywords(String strKeyword) {
		// base return
		if (strKeyword == null) {
			return null;
		}
		// remove the spaces at the end and beginning and replace space
		// in between category keywords with "%20"
		strKeyword = strKeyword.trim().replaceAll(" ", "%20");

		return strKeyword;
	}

	/**
	 * This method is used to contruct the URL for query the website using the
	 * keywords entered by the user and the page number
	 * 
	 * @param strKeyword
	 * @param pgNo
	 *            - is 1 for query type 1, userdefined for query type 2
	 * @return
	 */
	public String buildURL(String strKeyword, Integer pgNo) {
		if (strKeyword == null || pgNo == null) {
			return null;
		}

		// build the URL using a single StringBuilder object
		StringBuilder URLBuilder = new StringBuilder();
		URLBuilder.append("http://www.shopping.com/");
		URLBuilder.append(strKeyword + "/" + strKeyword + "/");
		URLBuilder.append("/products~PG-" + pgNo + "?CLT=SCH&KW=");
		URLBuilder.append(strKeyword);

		// Single object of URL string
		String strURL = URLBuilder.toString();
		return strURL;
	}
}
