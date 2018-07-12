package com.cafe.dao;
import java.sql.SQLException;
import java.util.List;
import com.cafe.beans.AddOn;
public interface AddOnDao {
	List<AddOn> listAllAddOn()throws ClassNotFoundException, SQLException;
	List<AddOn> listAllAddOn(String addOnCategory) throws ClassNotFoundException, SQLException ;
	boolean update(String addOnId, int addOnPrice,int addOnQuantity)throws ClassNotFoundException, SQLException;
	boolean insertAddOn(AddOn addon)throws ClassNotFoundException, SQLException;
	AddOn searchAddOn(String addOnId)throws ClassNotFoundException, SQLException;
	boolean deleteAddOn(String addOnId)throws ClassNotFoundException, SQLException;
}
