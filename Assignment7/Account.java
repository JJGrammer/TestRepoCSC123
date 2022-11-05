//Johann Jaramillo(jjaramillo26@toromail.csudh.edu)
public abstract class Account {
	private static int accountNumberCounter=1000;
	
	protected int accountNumber;
	protected String accountName;
	protected Customer accountHolder;
	protected double balance;
	protected boolean open=true;
	
	protected Account(String accountName, Customer accountHolder) {
		accountNumberCounter++;
		this.accountName=accountName;
		this.accountHolder=accountHolder;
		balance=0;
		accountNumber=accountNumberCounter;	
	}
	
	
	//extremely important method, Main does not work without this optional requirement
	public static int getAccountNumberCounter() {
		return accountNumberCounter;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public Customer getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getBalance() {
		return balance;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public boolean deposit(double amount) {
			balance+=amount; 
			return true;
	}
	
	public boolean withdraw(double amount) {
		
			balance-=amount; 
			return true; 
	}
	
	public void close() {
		open=false;
	}
	public boolean isOpen() {
		return open;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return accountNumber+"("+accountName+")"+ " : "+accountHolder.toString()+
			   " : "+balance+" : "+(open?"Account Open":"Account Closed");
	}
	
	
}
