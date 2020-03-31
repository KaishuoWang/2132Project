package classes;

import java.sql.Date;

public class rentalAgreement {
	private int agreementID;
	private int hostID;
	private int guestID;
	private int propertyID;
	private Date startDate;
	private Date endDate;
	private String signing;
	
	public rentalAgreement(int agreementID, int hostID, int propertyID, int guestID, Date startDate, Date endDate, String signing){
        this.setAgreementID(agreementID);
        this.setHostID(hostID);
        this.setGuestID(guestID);
        this.setPropertyID(propertyID);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setSigning(signing);
    }
	
	public rentalAgreement() {}

	public int getAgreementID() {
		return agreementID;
	}

	public void setAgreementID(int agreementID) {
		this.agreementID = agreementID;
	}

	public int getHostID() {
		return hostID;
	}

	public void setHostID(int hostID) {
		this.hostID = hostID;
	}

	public int getGuestID() {
		return guestID;
	}

	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}

	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSigning() {
		return signing;
	}

	public void setSigning(String signing) {
		this.signing = signing;
	}
}
