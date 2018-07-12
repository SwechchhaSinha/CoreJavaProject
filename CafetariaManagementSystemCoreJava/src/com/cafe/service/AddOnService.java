package com.cafe.service;

import java.util.List;

import com.cafe.beans.AddOn;

public interface AddOnService {
	List<AddOn> listAllAddOns();
	List<AddOn> listAllAddOns(String addOnCategory);
	boolean updateAddOn(int addOnPrice,int addOnQuantity);
	boolean insertAddOn(AddOn addon);
	AddOn searchAddOn(int addOnId);
	boolean deleteAddOn(int addOnId);
}
