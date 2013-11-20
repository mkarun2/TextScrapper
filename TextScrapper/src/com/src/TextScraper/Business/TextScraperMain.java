package com.src.TextScraper.Business;

import java.io.IOException;
import java.net.MalformedURLException;

public class TextScraperMain {

	public static void main(String[] args) {
		
		TextScraperAbstract tsa = null;
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
}
