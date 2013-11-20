package com.src.TextScraper.Business;

import java.io.IOException;
import java.net.MalformedURLException;

public class TextScraperMain {

	private TextScraperAbstract tsa;
	
	/**
	 * Private method to perform textScraping
	 * @param args
	 */
	private void URLTextScraper(String[] args){
		try{
			// no arguments provided
			if(args == null){throw new IllegalArgumentException("[ERROR]: Please provide the Search keyword and/or result page number");	}
			
			// No arguments provided
			if(args.length == 0){ throw new IllegalArgumentException("[ERROR]: Please provide the Search keyword and/or result page number");}
			
			// More than 3 arguments provided
			if(args.length > 2){ throw new IllegalArgumentException("[ERROR]: The application can take at the max of 2 arguments.");	}
			
			// if 1 argument provided, execute query 1
			if(args.length == 1){
				tsa = new TextScraperQuery1();
				System.out.println("\n[INFO]: Results after executing Query 1 \n");
				tsa.executeQuery(args[0], 1);
				System.out.println();
			}
			// if 2 arguments provided, execute query 2
			else if(args.length == 2){			
				if(!isInteger(args[1])) { throw new IllegalArgumentException("[ERROR]: The second argument can be only an Integer");	}
				tsa = new TextScraperQuery2();
				System.out.println("\n[INFO]: Results after executing Query 2 \n");
				tsa.executeQuery(args[0], Integer.parseInt(args[1]));				
				System.out.println();
			}else{
				throw new Exception("[ERROR]: No query executed");
			}
			
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("[INFO]: Invalid search keyword.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	 
	/**
	 * Method to check if entered input is integer
	 * @param s
	 * @return
	 */
	 public static boolean isInteger(String s) {
	     try { 
	         Integer.parseInt(s); 
	     } catch(NumberFormatException e) { 
	         return false; 
	     }
	     // only got here if we didn't return false
	     return true;
	 }
	
	/**
	 * Client Methods
	 * @param args
	 */
	public static void main(String[] args) {		
		TextScraperMain tsm = new TextScraperMain();
		tsm.URLTextScraper(args);
	}
}
