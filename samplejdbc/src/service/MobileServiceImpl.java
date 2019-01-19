package service;

import java.util.List;
import java.util.regex.Pattern;

import dao.MobileDao;
import dao.MobileDaoImpl;
import exception.MMSException;
import model.mob;

public class MobileServiceImpl implements MobileService {
	MobileDao mobdao = new MobileDaoImpl();

	@Override
	public List<mob> getAllEmployee() throws MMSException {

		return mobdao.getAllEmployee();
	}

	@Override
	public boolean getvaldate(String firstname) throws MMSException {
		String val = "[a-zA-Z]+$";
		boolean input = Pattern.matches(val, firstname);
		return input;
	}

	@Override
	public int getQuantity(int mobid) throws MMSException {
		// TODO Auto-generated method stub
		return mobdao.getQuantity(mobid);
	}

	@Override
	public int insertcust(mob m) throws MMSException {
		// TODO Auto-generated method stub
		return mobdao.insertcust(m);
	}

}
