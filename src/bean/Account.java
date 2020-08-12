package bean;



public class Account {
	private String accountId;
	private String accountName;
	private String addres;
	private int depositAmount;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String accountId, String accountName, String addres, int depositAmount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.addres = addres;
		this.depositAmount = depositAmount;
	}
	public void setDepositAmount(int d) {
		this.depositAmount = d;
	}
	
	
}
