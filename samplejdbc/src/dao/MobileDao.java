package dao;

import java.util.List;

import exception.MMSException;
import model.mob;

public interface MobileDao {

	List<mob> getAllEmployee() throws MMSException;

	int getQuantity(int mobid) throws MMSException;

	int insertcust(mob m) throws MMSException;

}
