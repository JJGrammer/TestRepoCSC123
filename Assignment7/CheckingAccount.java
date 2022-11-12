//Johann Jaramillo (jjaramillo26@toromail.csudh.edu)

public class CheckingAccount extends Account{
	private double overdraftLimit;
	
	public CheckingAccount( Customer accountHolder, double overdraft) {
		super("Checking", accountHolder);
		this.overdraftLimit=overdraft;
		
	}

	@Override
	public boolean deposit(double amount) {

		if(!isOpen())return false;
		Transaction CheckDepo= new Transaction("credit",amount);
		transactionArray.add(CheckDepo);
		return super.deposit(amount);
	}

	@Override
	public boolean withdraw(double amount) {
		
		if(isOpen()) {
		if(getBalance()-amount<0-overdraftLimit)return false;
		Transaction CheckWithdraw = new Transaction("debit",amount);
		transactionArray.add(CheckWithdraw);
		return super.withdraw(amount); }
		else {
			if (getBalance()-amount<0) return false;
			Transaction CheckWithdraw = new Transaction("debit",amount);
			transactionArray.add(CheckWithdraw);
			return super.withdraw(amount);
		}
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(int overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	
	
}
