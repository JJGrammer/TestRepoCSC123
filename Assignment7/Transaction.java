//Johann Jaramillo (jjaramillo26@toromail.csudh.edu)
import java.util.Random;
public class Transaction {
	
	protected static int transactionIDCounter=0; 
	protected int transactionID;
	protected String transType;
	protected double amount;
	Random rand = new Random();
	protected Transaction(String type, double amount) {
		this.transType=type;
		this.amount=amount;
		transactionIDCounter+=rand.nextInt(100);
		this.transactionID=transactionIDCounter;
	}
	
	public int getTransactionID() {
		return transactionID;
	}
	
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  transactionID+" : "+getTransType()+" : "+getAmount();
		
	}

	
}
