package Bank;
import java.util.ArrayList;
//Johann Jaramillo(jjaramillo26@toromail.csudh.edu)

public class Bank {
		
	private static ArrayList<Account> accounts= new ArrayList<Account>();
	
	public static Account openCheckingAccount(String firstName, String lastName, String SSN,double odL) {
		Customer c=new Customer(firstName, lastName, SSN);
		CheckingAccount CheckAcc = new CheckingAccount(c,odL);
		accounts.add(CheckAcc);
		return CheckAcc;
	}
	public static Account openCreditCardAccount(String firstName, String lastName, String SSN,double credLim) {
		Customer c=new Customer(firstName, lastName, SSN);
		CreditCardAccount CCAcc = new CreditCardAccount(c,credLim);
		accounts.add(CCAcc);
		return CCAcc;
	}
	
	public static Account openSavingAccount(String firstName, String lastName, String SSN) {
		Customer c=new Customer(firstName, lastName, SSN);
		SavingAccount SavAcc = new SavingAccount(c);
		accounts.add(SavAcc);
		return SavAcc;
	}
	
	public static Account lookup(int accountNumber) {
		for(Account a :accounts) {
			if(a.getAccountNumber()==accountNumber) return a;
				
		}
		return null;
	}
	
	public static void listAccounts() {
		for(Account a :accounts) {
			System.out.println(a);
		}
	}
		
	public static String storeData() {
		String dataStored= "";
		for(Account a :accounts) {
			dataStored+="Account & Customer: "+a.toString()+"\n";
			dataStored+="Transactions:\n"+a.saveStatements();
			
			
	}
		return dataStored; }
}
