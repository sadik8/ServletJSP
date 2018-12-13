package com.cg.web.obs.dto;

import java.sql.Date;

public class ServiceTracker 
{
	private int serviceID;
	private String serviceDescription;
	private long accountNumber;
	private Date serviceRaisedDate;
	private String serviceStatus;
	
	public ServiceTracker(){}
	
	public ServiceTracker(String serviceDescription, long accountNumber,
			String serviceStatus) {
		super();
		this.serviceDescription = serviceDescription;
		this.accountNumber = accountNumber;
		this.serviceStatus = serviceStatus;
	}



	public int getServiceID() {
		return serviceID;
	}



	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}



	public String getServiceDescription() {
		return serviceDescription;
	}



	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}



	public long getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public Date getServiceRaisedDate() {
		return serviceRaisedDate;
	}



	public void setServiceRaisedDate(Date serviceRaisedDate) {
		this.serviceRaisedDate = serviceRaisedDate;
	}



	public String getServiceStatus() {
		return serviceStatus;
	}



	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}



	@Override
	public String toString() {
		return "ServiceTracker [serviceID=" + serviceID
				+ ", serviceDescription=" + serviceDescription
				+ ", accountNumber=" + accountNumber + ", serviceRaisedDate="
				+ serviceRaisedDate + ", serviceStatus=" + serviceStatus + "]";
	}
	
	
}
