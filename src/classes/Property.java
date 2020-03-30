package classes;

import java.sql.Date;

public class Property {
	private int propertyID;
	private int ownerID;
	private int houseNum;
	private String street;
	private String city;
	private String province;
	private String country;
	private String roomType;
	private float price;
	private Date availableDate;
	private String propertyType;
	private String propertyClass;
	private int numGuest;
	private String amenities;
	private String rules;
	
	public Property(int propertyID, int ownerID, int houseNum, String street, String city, String province, String country, String roomType, float price, String propertyClass) {
		this.setPropertyID(propertyID);
		this.setOwnerID(ownerID);
		this.setHouseNum(houseNum);
		this.setStreet(street);
		this.setCity(city);
		this.setProvince(province);
		this.setCountry(country);
		this.setRoomType(roomType);
		this.setPrice(price);
		this.setPropertyClass(propertyClass);
	}

	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyClass() {
		return propertyClass;
	}

	public void setPropertyClass(String propertyClass) {
		this.propertyClass = propertyClass;
	}

	public int getNumGuest() {
		return numGuest;
	}

	public void setNumGuest(int numGuest) {
		this.numGuest = numGuest;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}
	
}
