package Bank;
//Johann Jaramillo(jjaramillo26@toromail.csudh.edu)

public class CreditCardAccount extends Account{

	private double creditLimit;
	public CreditCardAccount(Customer accountHolder, double creditLimit) {
		super("Credit Card", accountHolder);
		this.creditLimit=creditLimit;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		Transaction transCredDepos = new Transaction("debit",amount);
		transactionArray.add(transCredDepos);
		return super.withdraw(amount);
		
	}
	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		if(!isOpen())return false;
		if(getBalance()+amount>creditLimit)return false;
		Transaction transCredWith = new Transaction("credit",amount);
		transactionArray.add(transCredWith);

		return super.deposit(amount);
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	
	
}
