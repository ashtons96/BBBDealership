package com.revature.Sullivan.DAO;

import java.util.Map;

public interface LoginListDAO {

	public void saveLoginList(Map<String,String> CustomerLoginMap);
	
	public Map<String,String> loadLoginList();
	
}
