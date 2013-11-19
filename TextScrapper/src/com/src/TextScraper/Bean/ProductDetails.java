package com.src.TextScraper.Bean;

/**
 * This class represents the required details for a 
 * particular Product.
 */
public class ProductDetails {
	
	public ProductDetails(){
		this.strShipping = "No Shipping Info";
	}
	
	// Create a product object
	public ProductDetails(String title,
			String price, String ship, String vendor, String stores){
		
		if(title == null){ title = "No Title"; }
		if(price == null){ price = "No price"; }
		if(ship == null){ ship = "No Shipping Info"; }
		if(vendor == null){ vendor = "No Vendor Info"; }
		if(stores == null){ stores = ""; }
		
		this.strProductName = title;	
		this.strPrice = price;	
		this.strShipping = ship;	
		this.strVendor = vendor;		
		this.strStores = stores;
	}
	
	public String getStrProductName() {
		return strProductName;
	}

	public void setStrProductName(String strProductName) {
		this.strProductName = strProductName;
	}

	public String getDbPrice() {
		return strPrice;
	}

	public void setDbPrice(String dbPrice) {
		this.strPrice = dbPrice;
	}

	public String getDbShipPrice() {
		return strShipping;
	}

	public void setDbShipPrice(String dbShipPrice) {
		this.strShipping = dbShipPrice;
	}

	public String getStrVendor() {
		return strVendor;
	}

	public void setStrVendor(String strVendor) {
		this.strVendor = strVendor;
	}
	
	public String getiStores() {
		return strStores;
	}

	public void setiStores(String iStores) {
		this.strStores = iStores;
	}

	//Product Title
	private String strProductName;
	
	//Price of the product
	private String strPrice;
	
	// Shipping price as String because shipping can be free shipping
	private String strShipping;
	
	//Product Selling Vendor
	private String strVendor;
	
	// The number of stores this product is present with respect to the current vendor
	private String strStores;
}
