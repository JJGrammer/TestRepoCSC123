package Bank;
//Johann Jaramillo(jjaramillo26@toromail.csudh.edu)

public class Customer {
	private String firstName="",lastName="",ssn="";
	
	public Customer(String fname, String lname, String ssn) {
		this.firstName=fname;
		this.lastName=lname;
		this.ssn=ssn;
	}
	
	public void setfirstName(String fname){
		this.firstName = fname;
	}
	public void setlastName(String lname){
		this.lastName = lname;
	}
	public void setEmail(String ssn){
		this.ssn = ssn;
	}
	public String getfirstName(){
		return this.firstName ;
	}
	public String getlastName(){
		return this.lastName ;
	}
	public String getSSN(){
		return this.ssn ;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getlastName()+" : "+ getfirstName()+" : "+ getSSN();
	}
	
	
}
