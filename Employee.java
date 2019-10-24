package Company;

public abstract class Employee {
	
	private String Name;
	private String ID;
	private double GrossSalary;
	final double TAXRATE = 0.1;
	


Employee (String Name, String ID, double GrossSalary) {
	this.Name = Name;
	this.ID = ID;
	this.GrossSalary = GrossSalary;

}

public String getName() {
	 return Name;
}

public String getID() {
	 return ID;
}

public double getGrossSalary() {
	return GrossSalary;
}

public double getGrossSalaryNoBonus() {
	return GrossSalary;
}

public abstract double getNetSalary(); 

public void setName(String newName) {
	Name = newName;
	
}

public void setSalary(double newSalary) {
	GrossSalary = newSalary;
	
}

public String toString() {
	String Info = this.Name + "'s" + " gross salary is of " + String.format("%.0f",this.GrossSalary) + " SEK per month.";
	return Info;
}



}