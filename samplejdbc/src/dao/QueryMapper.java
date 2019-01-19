package dao;

public interface QueryMapper {
	public static final String getmob="select * from mobile_master";
	public static final String getquan="select quantity from mobile_master where mobid=?";
	public static final String insertcust="insert into cust_master values(cust_sequence.nextval,?,?,?,?)";
	public static final String update="update mobile_master set quantity=quantity-? where mobid=?";
			
}
