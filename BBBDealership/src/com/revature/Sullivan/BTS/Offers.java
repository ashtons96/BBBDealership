package com.revature.Sullivan.BTS;

public class Offers {
	
	private Integer offerPrice;
	
	private int offerID;

	private Customers offerCust;
	
	private Car offerCar;
	
	

	public Offers(Car offerCar, Customers offerCust, Integer offerPrice, Integer offerID) {
		super();
		
		this.offerCar = offerCar;
		this.offerCust = offerCust;
		this.offerPrice = offerPrice;
		this.offerID = offerID;
	}

	public int getOfferID() {
		
		return offerID;
	}

	public void setOfferID(int offerID) {
		
		this.offerID = offerID;
	}		
	

	public Car getOfferCar() {
	
		return offerCar;
	}

	public void setOfferCar(Car offerCar) {
	
		this.offerCar = offerCar;
	}

	public Customers getOfferCust() {
	
		return offerCust;
	}

	public void setOfferCust(Customers offerCust) {
	
		this.offerCust = offerCust;
	}
	
	public Integer getOfferPrice() {
	
		return offerPrice;
	}

	public void setOfferPrice(Integer offerPrice) {
	
		this.offerPrice = offerPrice;
	}	



	@Override
	public String toString() {
		return "Offer [offerID=" + offerID + ", offerCarID=" + offerCar.getCarID() + ", offerCarMakeAndModel="
				+ offerCar.getCarMakeAndModel() + ", offerCarOriginalPrice=" + offerCar.getPrice() + ", offerCust="
				+ offerCust.getUsername() + ", offerPrice=" + offerPrice + "]";
	}


}
