package model;

import java.io.Serializable;
import java.time.LocalDate;

public class mob implements Serializable {
	private Integer custid;

	@Override
	public String toString() {
		return "mob [custid=" + custid + ", custname=" + custname + ", prodname=" + prodname + ", custquant="
				+ custquant + ", buydate=" + buydate + ", mobid=" + mobid + ", procname=" + procname + ", quantity="
				+ quantity + "]";
	}

	private String custname;
	private String prodname;
	private Integer custquant;
	private LocalDate buydate;
	private Integer mobid;
	private String procname;
	private Integer quantity;

	public mob() {
		super();
		// TODO Auto-generated constructor stub
	}

	public mob(Integer custid, String custname, String prodname, Integer custquant, LocalDate buydate, Integer mobid,
			String procname, Integer quantity) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.prodname = prodname;
		this.custquant = custquant;
		this.buydate = buydate;
		this.mobid = mobid;
		this.procname = procname;
		this.quantity = quantity;
	}

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public Integer getCustquant() {
		return custquant;
	}

	public void setCustquant(Integer custquant) {
		this.custquant = custquant;
	}

	public LocalDate getBuydate() {
		return buydate;
	}

	public void setBuydate(LocalDate buydate) {
		this.buydate = buydate;
	}

	public Integer getMobid() {
		return mobid;
	}

	public void setMobid(Integer mobid) {
		this.mobid = mobid;
	}

	public String getProcname() {
		return procname;
	}

	public void setProcname(String procname) {
		this.procname = procname;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
