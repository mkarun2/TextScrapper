package com.src.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLUtilities {

	public static void main(String[] args) {
		System.out.println(new URLUtilities().GetHTMLContentFromURL("http://www.shopping.com/Digital-Cameras/products?CLT=SAS&KW=Digital+Cameras"));
	}
	
	/**
	 * GetHTMLContentFromURL is used to parse return the viewSource(HTML content) 
	 * of the strURL, a web page URL
	 * @param strURL
	 * @return
	 */
	public String GetHTMLContentFromURL(String strURL){
		URL url = null;
		URLConnection urlConnection = null;
		BufferedReader buffReader = null;
		String strInputLine = null;
		StringBuilder sbHTMLContent = null;
		
		try {
			//Convert from string URL to URL type
			url = new URL(strURL.trim());
			
			//open the URL Connection to open the web page
			urlConnection = url.openConnection();
			
			// Initialize a buffered Reader to read the contents through the Input Stream
			// The encoding assumed here is UTF-8 since it is the most prevalent in recent application
			buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));            
			sbHTMLContent = new StringBuilder();
			
			//read the contents line by line and add to String Builder object which does not 
			//cause immutable strings and saves space
            while ((strInputLine = buffReader.readLine()) != null){
            	sbHTMLContent.append(strInputLine + "\n");
            }
            buffReader.close();	  
            if(sbHTMLContent != null){
            	return sbHTMLContent.toString();	// return a single string of the HTML contents
            }
            
		} catch (MalformedURLException e) {
			System.out.println("[ERROR]: Malformed URL Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR]: IO Exception due to buffered reader and input stream");
			e.printStackTrace();
		}
		
		// this point is not reached, but just in case
        return null;
	}
}
