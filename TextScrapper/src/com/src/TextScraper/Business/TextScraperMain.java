package com.src.TextScraper.Business;

public class TextScraperMain {

	public static void main(String[] args) {
		try{
			TextScraperAbstract textScraperObj = new TextScraperQuery2();
			textScraperObj.executeQuery("Digital Cameras",1);
			textScraperObj.displayResult();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
