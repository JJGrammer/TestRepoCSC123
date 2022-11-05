//Johann Jaramillo(jjaramillo26@toromail.csudh.edu)

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		//control variables
		int sentinel = 0;int tempAccountNum=0;
		//argument variables for customer
		String fName,lName,SSN;
		//arguments for checking and credit accounts
		int overdraftLim,creditLim;
		while (sentinel !=8) {
			
			System.out.println("1 - Open Checking\n2 - Open Saving\n3 - Open Credit\n4 - List Accounts\n5 - Deposit Funds\n6 -"
					+ " Withdraw Funds\n7 - Close an Account\n8 - Exit\n\nPlease enter your choice: ");
			sentinel = scan.nextInt();
			
			
			switch(sentinel) {
			//fall through cases 1-3 since they mostly perform the same operations. May change in the future
			case 1:
			case 2:
			case 3:
				System.out.println("Enter first name: ");
				fName=scan.next();
				System.out.println("Enter last name: ");
				lName=scan.next();
				System.out.println("Enter Social Security Number: ");
				SSN=scan.next();
				//checking account
				if(sentinel==1) {
					System.out.println("Enter Overdraft Limit: ");
					overdraftLim=scan.nextInt();
					Bank.openCheckingAccount(fName, lName, SSN,overdraftLim );}
				//savings account
				if (sentinel==2) {
					Bank.openSavingAccount(fName,lName,SSN);
				}
				//credit card account
				if (sentinel==3) {
					System.out.println("Enter Credit Limit");
					creditLim=scan.nextInt();
					Bank.openCreditCardAccount(fName, lName, SSN, creditLim);
				}
				
				System.out.println("Thank you, the account number is "+Bank.lookup(Account.getAccountNumberCounter()).getAccountNumber());
			break;
			//display all accounts, regardless of status, type
			case 4:
				Bank.listAccounts();
				break;
			case 5:
				//deposit money into account.
				System.out.println("Enter account number: ");
				 tempAccountNum=scan.nextInt();
				System.out.println("Enter the amount to deposit: ");
				double depositAmount=scan.nextDouble();
				//if an account is found
				if(Bank.lookup(tempAccountNum) != null) {
					//if the deposit goes through
					if(Bank.lookup(tempAccountNum).deposit(depositAmount)) {
						//dsiplay info
					System.out.println("Deposit successful, the new balance is: "+Bank.lookup(tempAccountNum).getBalance());
				}	//if didnt go through
					else {
						System.out.println("Deposit failed, the balance is: "+Bank.lookup(tempAccountNum).getBalance());
					}
				}
				//if accouunt not found
				else { System.out.println("Account not found.");}
				break;
				
			case 6:
				//withdrawing money, with similar principles to case 5
				System.out.println("Enter account number: ");
				tempAccountNum=scan.nextInt();
				System.out.println("Enter the amount to withdraw: ");
				double withdrawAmount=scan.nextDouble();
				
				if(Bank.lookup(tempAccountNum) != null) {
					if(Bank.lookup(tempAccountNum).withdraw(withdrawAmount)) {
					System.out.println("Withdrawal successful, the new balance is: "+Bank.lookup(tempAccountNum).getBalance());
				}
					else {
						System.out.println("Withdrawal failed, the balance is: "+Bank.lookup(tempAccountNum).getBalance());
					}
				}
				else { System.out.println("Account not found.");}
				break;
				
			case 7:
				//close accounts, similar principles to 6&7
				System.out.println("Enter the account number to close: ");
				tempAccountNum=scan.nextInt();
				
				if(Bank.lookup(tempAccountNum)!=null) {
					Bank.lookup(tempAccountNum).close();
					System.out.println("Account closed, current balance is "+Bank.lookup(tempAccountNum).getBalance()
							+", deposits are no longer possible");
				}
				else{System.out.println("Account not found.");}	
				break;
				
			case 8:
				sentinel=8;
				scan.close();
				System.out.println("Exiting program..."); 
	
	
			
			}
		}	
	}
}
