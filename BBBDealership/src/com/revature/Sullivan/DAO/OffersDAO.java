package com.revature.Sullivan.DAO;

import java.util.List;

import com.revature.Sullivan.BTS.Offers;

public interface OffersDAO {
	
public void saveOfferList(List<Offers> offerList);
	
	public List<Offers> loadOfferList();

}
