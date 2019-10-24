package Company;

public class Manager extends RegularEmployee {

	private String Degree;
	final double BSCBONUS = 0.1;
	final double MSCBONUS = 0.2;
	final double PHDBONUS = 0.35;
	
	Manager (String Name, String ID, double GrossSalary, String Degree) {
		super(Name, ID, GrossSalary);
		this.Degree = Degree;
	}
	
	public String getDegree() {
		return Degree;
	}
	
	public void setDegree(String newDegree) {
		this.Degree = newDegree;
	}
	
	
	public double getGrossSalary() {
		double grossSalary = super.getGrossSalary() + getBonus();
		return grossSalary;
	}
	
	
	
	public double getBonus() {
		double bonus = 0;
		if ("PhD".equalsIgnoreCase(this.Degree)) {
			bonus = super.getGrossSalary() * PHDBONUS ;
			 	
		} else if ("MSc".equalsIgnoreCase(this.Degree)) {
			bonus = super.getGrossSalary() * MSCBONUS ;
		} else if ("BSc".equalsIgnoreCase(this.Degree)){
			bonus = super.getGrossSalary() * BSCBONUS ;
		} else {
			System.out.println();
		}
		 return bonus;
	}
	
	public double getPercentageBonus() {
		double bonus = (getBonus() / super.getGrossSalary()) * 100;
		return bonus;
	}
	
	
	
	public String toString() {
		final String END_OF_LINE = System.lineSeparator();
		String Info = getName() + " has a gross salary of " + String.format("%.0f",getGrossSalaryNoBonus()) + " SEK with a " + getDegree() + " degree"+ END_OF_LINE;
		Info += "The employee will recieve a bonus of " + String.format("%.0f", getPercentageBonus()) + "% (" + String.format("%.0f",getBonus()) + " SEK)" + END_OF_LINE;
		Info += "The total gross salary of the employee is: " + String.format("%.0f",getGrossSalary()) + " SEK";
		return Info;
	}
	
}
