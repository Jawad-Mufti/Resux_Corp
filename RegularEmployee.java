package Company;

public class RegularEmployee extends Employee {

	

	RegularEmployee(String Name, String ID, double GrossSalary) {
		super(Name, ID, GrossSalary);
	}
	
	public double getNetSalary() {
		double netSalary = this.getGrossSalary() - (this.getGrossSalary() * TAXRATE);
		return netSalary;
	}

}
