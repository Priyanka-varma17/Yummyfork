package com.yummyfork.dto;

public class Customer {
	
	private int custId;
	private String custName;
	private String custAddress;
	private long custMobile;
	private String custEmail;
	
	public Customer() {
		super();
	}

	public Customer(int custId, String custName, String custAddress, long custMobile, String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custMobile = custMobile;
		this.custEmail = custEmail;
	}

	public Customer(String custName, String custAddress, long custMobile, String custEmail) {
		super();
		System.out.println("inside customer constructor");
		this.custName = custName;
		this.custAddress = custAddress;
		this.custMobile = custMobile;
		this.custEmail = custEmail;
	}
	public Customer(String custName, String custAddress, long custMobile) {
		super();
		System.out.println("inside customer constructor");
		this.custName = custName;
		this.custAddress = custAddress;
		this.custMobile = custMobile;
	}

	public Customer(int custId) {
		super();
		this.custId = custId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public long getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	

}
