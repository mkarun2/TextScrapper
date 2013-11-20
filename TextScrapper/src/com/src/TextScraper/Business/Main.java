package com.src.TextScraper.Business;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import org.apache.commons.httpclient.URIException;

public class Main {

	public static void main(String[] args) throws URIException, UnsupportedEncodingException, MalformedURLException {
//		String s = URLEncoder.encode("assdsdsdad#$%!@", "UTF-8");
//		StringBuilder URLBuilder = new StringBuilder();
//		URLBuilder.append("http://www.shopping.com/");
//		URLBuilder.append(s + "/" + s + "/");
//		URLBuilder.append("products~PG-" + "1" + "?CLT=SCH&KW=");
//		URLBuilder.append(s);
//		System.out.println(URLBuilder);
//		String urlStr = "http://www.shopping.com/digital cameras/Digital Cameras/products~PG-1?KW=Digital Cameras";
//		URL url = new URL(urlStr);
//		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
//		String encodedSearchKeyword = URLEncoder.encode("assdsdsdad#$%!@", "UTF-8");
//		System.out.println(uri.toString());
		
		String s = "+ $5.49 shipping";
		s = s.replace("+","");
		System.out.println(s);
		
	}
	
}
