package com.revature.Sullivan.BTS;

import java.util.ArrayList;
import java.util.List;

public class Car {
	private Integer carID;
	private String ownerUsername;
	private String price;
	
	private String carMakeAndModel;
	private Boolean forSale;
	private List<Offers> carOfferList;
	private String purchasedPrice;


	
	public Car(String ownerUsername, String price, String carType, Boolean forSale) {
		super();
		
		this.ownerUsername = ownerUsername;
		this.price = price;
		this.carMakeAndModel = carMakeAndModel;

		this.forSale = forSale;
		this.carOfferList = new ArrayList<>();
		this.purchasedPrice = price;

	}


	public Car(String ownerUsername, String price, String carType, Boolean forSale, Integer carID) {
		super();
		this.ownerUsername = ownerUsername;
		this.price = price;
		this.carMakeAndModel = carMakeAndModel;

		this.forSale = forSale;
		this.carID = carID;
		this.carOfferList = new ArrayList<>();
		this.purchasedPrice = price;

	}

	public String getPurchasedPrice() {
		return purchasedPrice;
		
	}

	public void setPurchasedPrice(String purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	
	}

	public List<Offers> getCarOfferList() {
		return carOfferList;
	
	}

	public void setCarOfferList(List<Offers> carOfferList) {
		this.carOfferList = carOfferList;
	
	}

	public String getOwnerUsername() {
		return ownerUsername;
	
	}

	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCarMakeAndModel() {
		return carMakeAndModel;
	}

	public void setCarMakeAndModel(String carType) {
		this.carMakeAndModel = carMakeAndModel;
	}

	public Boolean getForSale() {
		return forSale;
	}

	public void setForSale(Boolean forSale) {
		this.forSale = forSale;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(Integer carID) {
		this.carID = carID;
	}

	@Override
	public String toString() {
		return "Boat [boatID=" + carID + ", ownerUsername=" + ownerUsername + ", dealerPrice=" + price
				+ ", purchasedPrice=" + purchasedPrice + ", boatType=" + carMakeAndModel + ", forSale=" + forSale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 28;
		int result = 1;
		result = prime * result + ((carMakeAndModel == null) ? 0 : carMakeAndModel.hashCode());
		result = prime * result + ((forSale == null) ? 0 : forSale.hashCode());
		result = prime * result + ((ownerUsername == null) ? 0 : ownerUsername.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carMakeAndModel == null) {
			if (other.carMakeAndModel != null)
				return false;
		} else if (!carMakeAndModel.equals(other.carMakeAndModel))
			return false;
		if (forSale == null) {
			if (other.forSale != null)
				return false;
		} else if (!forSale.equals(other.forSale))
			return false;
		if (ownerUsername == null) {
			if (other.ownerUsername != null)
				return false;
		} else if (!ownerUsername.equals(other.ownerUsername))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	public Customers getOfferCust() {
		// TODO Auto-generated method stub
		return null;
	}

	public Car getOfferCar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getOfferID() {
		// TODO Auto-generated method stub
		return null;
	}

}
