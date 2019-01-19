package service;

import java.util.List;

import exception.MMSException;
import model.mob;

public interface MobileService {

	List<mob> getAllEmployee() throws MMSException;

	boolean getvaldate(String firstname) throws MMSException;

	int getQuantity(int mobid) throws MMSException;

	int insertcust(mob m) throws MMSException;

}
