package Company;

public class Director extends Manager {
	private String Department;
	private static double Benefit = 5000;
	
	Director(String Name, String ID, double GrossSalary, String Degree, String Department) {
		super(Name, ID, GrossSalary,Degree);
		this.Department = Department;
	}
	
	public double getBenefit() {
		return Benefit;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	public static void setBenefit(double newBenefit) {
		Benefit = newBenefit;
		
	}
	
	
	
	public double getGrossSalary() {
		double grossSalary = super.getGrossSalary() + Benefit;
		return grossSalary;
		
	}
	
	
	public double getNetSalary() {
		double grossSalary = 0;
		
		if (getGrossSalary() > 50000) {
			grossSalary = getGrossSalary() - (30000 * 0.2) - ((getGrossSalary() - 30000) * 0.4);
			
		}
		
		else if (getGrossSalary() > 30000 && getGrossSalary() < 50000) {
		
		grossSalary = getGrossSalary() - (getGrossSalary() * 0.2);
	} else {
		grossSalary = super.getNetSalary();
	}
		return grossSalary;
	}
	
	public String toString() {
		final String END_OF_LINE = System.lineSeparator();
		String Info = getName() + " has a gross salary of " + String.format("%.0f",getGrossSalaryNoBonus()) + " SEK with a " + getDegree() + " degree"+ END_OF_LINE;
		Info += "The employee will recieve a bonus of " + String.format("%.0f", getPercentageBonus()) + "% (" + String.format("%.0f",getBonus()) + " SEK)" + END_OF_LINE;
		Info += getName() + " works in the " + getDepartment() + " department and will recieve a benefit of " + String.format("%.0f",getBenefit()) + " SEK" + END_OF_LINE;
		Info += "The total gross salary of the employee is: " + String.format("%.0f",getGrossSalary()) + " SEK";
		return Info;
	}

}
