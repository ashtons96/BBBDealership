package com.revature.Sullivan.BTS;

import java.util.HashMap;
import java.util.Map;

public class CustLoginList {

		private static final Map<String, String> CustomerLoginMap = new HashMap<>();

		public static Map<String, String> getCustomerloginmap() {
			return CustomerLoginMap;
		}
}
