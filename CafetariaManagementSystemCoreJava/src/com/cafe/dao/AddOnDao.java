package com.cafe.dao;
import java.util.List;
import com.cafe.beans.AddOn;
public interface AddOnDao {
	List<AddOn> listAllAddOn();
	List<AddOn> listAllAddOn(String addOnCategory);
	boolean update(int addOnPrice,int addOnQuantity);
	boolean insertAddOn(AddOn addon);
	AddOn searchAddOn(int addOnId);
	boolean deleteAddOn(int addOnId);
}
