package Types;

public class Payment {
	private int paymentID;
	private int hostID;
	private String paymentType;
	private float amount;
	private String status;
	
	public Payment(int paymentID, int hostID, String paymentType, float amount, String status){
		this.setPaymentID(paymentID);
		this.setHostID(hostID);
		this.setPaymentType(paymentType);
		this.setAmount(amount);
		this.setStatus(status);
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public int getHostID() {
		return hostID;
	}

	public void setHostID(int hostID) {
		this.hostID = hostID;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
