package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.MMSException;
import model.mob;
import utility.JdbcUtility;

public class MobileDaoImpl implements MobileDao {
	PreparedStatement statement = null;
	Connection connection = null;

	@Override
	public List<mob> getAllEmployee() throws MMSException {
		List<mob> list = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.getmob);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String productname = resultSet.getString(2);
				int quantity = resultSet.getInt(3);
				mob m = new mob();
				m.setMobid(id);
				m.setProcname(productname);
				m.setQuantity(quantity);
				list.add(m);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int getQuantity(int mobid) throws MMSException {
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		int quan = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.getquan);
			statement.setInt(1, mobid);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				quan = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return quan;
	}

	@Override
	public int insertcust(mob m) throws MMSException {
		int result = 0;
		connection = JdbcUtility.getConnection();
		Date dob = Date.valueOf(m.getBuydate());
		try {
			statement = connection.prepareStatement(QueryMapper.insertcust);
			statement.setString(1, m.getCustname());
			statement.setString(2, m.getProdname());
			statement.setInt(3, m.getQuantity());
			statement.setDate(4, dob);
			result = statement.executeUpdate();
			statement = connection.prepareStatement(QueryMapper.update);
			statement.setInt(1, m.getQuantity());
			statement.setInt(2, m.getMobid());
			result = statement.executeUpdate();
			System.out.println("update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
