//Johann Jaramillo(jjaramillo26@toromail.csudh.edu)
package Bank;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan= new Scanner(System.in);
		//control variables
		int sentinel = 0;int tempAccountNum=0;
		//argument variables for customer
		String fName,lName,SSN;
		//arguments for checking and credit accounts
		int overdraftLim,creditLim;
		
		while (sentinel !=-1) {
			
			System.out.println("1 - Open Checking\n2 - Open Saving\n3 - Open Credit\n4 - List Accounts\n5 - Account Statement\n6 - Deposit Funds\n7 -"
					+ " Withdraw Funds\n8 - Close an Account\n9 - Exit\n\nPlease enter your choice: ");
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
				System.out.println("Enter account number: ");
				tempAccountNum=scan.nextInt();
				
				if(Bank.lookup(tempAccountNum)!=null) {
					Bank.lookup(tempAccountNum).printStatement();
				}
				else {System.out.println("Account not found."); }
				break;
				
				
			case 6:
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
				
			case 7:
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
				
			case 8:
				//close accounts, similar principles to 6&7
				System.out.println("Enter the account number to close: ");
				tempAccountNum=scan.nextInt();
				
				if(Bank.lookup(tempAccountNum)!=null) {
					Bank.lookup(tempAccountNum).close();
					//since a bank would not allow you to borrow money without a way to pay it back, i've locked off negative withdrawals
					System.out.println("Account closed, current balance is "+Bank.lookup(tempAccountNum).getBalance()
							+", deposits and overdrafting withdrawals are no longer possible");
				}
				else{System.out.println("Account not found.");}	
				break;
				
			case 9:
				//copy all important data to a file
				sentinel=-1;
				//create a txt file named bankinfo
				File BankFile= new File("BankInfo.txt");
				//if the file does not exist in memory yet
				if(!BankFile.exists()) {
					//create it
					BankFile.createNewFile();
					//write to it using FW Class
					FileWriter bankFW= new FileWriter(BankFile);
					//writes, then flushes
						bankFW.write(Bank.storeData());
						bankFW.flush();
						bankFW.close();} 
				else {
					FileWriter bankFWappend= new FileWriter(BankFile,true);
						bankFWappend.write(Bank.storeData());
						bankFWappend.flush();
						bankFWappend.close();} 
				scan.close();
				System.out.println("Exiting program..."); 
			
			}
		}	
	}
}
