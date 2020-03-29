package Types;

public class Branch {
	private int branchID;
	private int branchMgr;
	private String country;
	
	public Branch(int branchID, String country) {
		this.setBranchID(branchID);
		this.setCountry(country);
	}

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public int getBranchMgr() {
		return branchMgr;
	}

	public void setBranchMgr(int branchMgr) {
		this.branchMgr = branchMgr;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
