package classes;

public class Pricing {
	private String propertyClass;
	private float price;

	public Pricing(String propertyClass) {
		this.propertyClass = propertyClass;
	}

	public String getPropertyClass() {
		return propertyClass;
	}

	public void setPropertyClass(String propertyClass) {
		this.propertyClass = propertyClass;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
