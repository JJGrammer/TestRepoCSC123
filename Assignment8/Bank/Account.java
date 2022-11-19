package Bank;
import java.util.ArrayList;
//Johann Jaramillo(jjaramillo26@toromail.csudh.edu)

public abstract class Account {
	private static int accountNumberCounter=1000;
	
	protected int accountNumber;
	protected String accountName;
	protected Customer accountHolder;
	protected boolean open=true;
	protected ArrayList<Transaction> transactionArray= new ArrayList<Transaction>();
	protected Account(String accountName, Customer accountHolder) {
		accountNumberCounter++;
		this.accountName=accountName;
		this.accountHolder=accountHolder;
		
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
		double balance=0;
		for(Transaction t:transactionArray) {
			if(t.getTransType().equals("credit")) {
				balance+=t.getAmount();
			}
			else{balance-=t.getAmount();}
		}
		return balance;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public boolean deposit(double amount) {
			return true;
	}
	
	public boolean withdraw(double amount) {
		
			return true; 
	}
	
	public void close() {
		open=false;
	}
	
	protected void addTransToArray(Transaction trans) {
		transactionArray.add(trans);
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public void printStatement() {
		for (Transaction t: transactionArray) {
			System.out.println(t);
		}
		System.out.println(".\n.\n.\nBalance: "+getBalance());
	}
	public String saveStatements() {
		String statementList="";
		for (Transaction t: transactionArray) {
			statementList+=t.toString()+"\n";
		}
		return statementList;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return accountNumber+"("+accountName+")"+ " : "+accountHolder.toString()+
			   " : "+getBalance()+" : "+(open?"Account Open":"Account Closed");
	}
	
	
}
