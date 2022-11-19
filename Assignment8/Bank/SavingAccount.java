package Bank;
//Johann Jaramillo(jjaramillo26@toromail.csudh.edu)

public class SavingAccount extends Account{

		public SavingAccount( Customer accountHolder) {
			super("Saving", accountHolder);
		}

		@Override
		public boolean deposit(double amount) {

			if(!isOpen())return false;
			//prevents negative integers from reducing the balance
			else if((getBalance()+amount<0)) {
				return false; }
			Transaction SavingDepo = new Transaction("credit",amount);
			transactionArray.add(SavingDepo);
			return super.deposit(amount); 
		}

		@Override
		public boolean withdraw(double amount) {
			if(getBalance()-amount<0)return false;
			Transaction SavingWithdraw= new Transaction("debit",amount);
			transactionArray.add(SavingWithdraw);
			return super.withdraw(amount);
		}
}
