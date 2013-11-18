package com.src.TextScraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLRetriever {

	public static void main(String[] args) {
		GetHTMLContentFromURL("http://www.shopping.com/Digital-Cameras/products?CLT=SAS&KW=Digital+Cameras");
	}
	
	public static void GetHTMLContentFromURL(String strURL){
		URL url = null;
		URLConnection urlConnection = null;
		BufferedReader buffReader = null;
		String strInputLine = null;
		StringBuilder sbHTMLContent = null;
		
		try {
			url = new URL(strURL);
			urlConnection = url.openConnection();
			buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));            
			sbHTMLContent = new StringBuilder();
            while ((strInputLine = buffReader.readLine()) != null){
            	sbHTMLContent.append(strInputLine);
            }
            buffReader.close();	
            System.out.println(sbHTMLContent.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
