package Types;

public class Host {
	private int hostID;
	private int houseNum;
	private String street;
	private String city;
	private String province;
	private String hostFN;
	private String hostMN;
	private String hostLN;
	private String emailAddress;
	private int phoneNum;
	
	public Host(String fName, String mName, String lName, int ID) {
		this.setHostFN(fName);
		this.setHostMN(mName);
		this.setHostLN(lName);
		this.setHostID(ID);
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public int getHostID() {
		return hostID;
	}

	public void setHostID(int hostID) {
		this.hostID = hostID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getHostFN() {
		return hostFN;
	}

	public void setHostFN(String hostFN) {
		this.hostFN = hostFN;
	}

	public String getHostMN() {
		return hostMN;
	}

	public void setHostMN(String hostMN) {
		this.hostMN = hostMN;
	}

	public String getHostLN() {
		return hostLN;
	}

	public void setHostLN(String hostLN) {
		this.hostLN = hostLN;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}