package classes;

public class Host {
	private int hostID;
	private int houseNum;
	private String street;
	private String city;
	private String province;
	private String hostFN;
	private String hostLN;
	private String emailAddress;
	private int phoneNum;
	private String password;
	
	public Host(String fName, String lName, int ID, String password) {
		this.setHostFN(fName);
		this.setHostLN(lName);
		this.setHostID(ID);
		this.password = password;
	}

	public Host() {}
	
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}