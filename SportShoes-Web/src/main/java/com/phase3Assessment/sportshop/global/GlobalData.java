package com.phase3Assessment.sportshop.global;

import java.util.ArrayList;
import java.util.List;

import com.phase3Assessment.sportshop.persistence.model.Product;

public class GlobalData {

	public static List<Product> cart;
	static {
		cart =new ArrayList<Product>();
	}
}
