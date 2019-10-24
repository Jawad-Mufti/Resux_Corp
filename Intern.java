package Company;

public class Intern extends RegularEmployee {
	private int GPA;
	
	Intern (String Name, String ID, double GrossSalary, int GPA) {
		super(Name, ID, GrossSalary);
		this.GPA = GPA;
	}
	
	public int getGPA() {
		return GPA;
	}
	
	public void setGPA(int newGPA) {
		this.GPA = newGPA;
	}
	
	
	
	public double getGrossSalary() {
		double grossSalary;
		if (GPA >= 8 ) {
			grossSalary = super.getGrossSalary() + 1000;
		} else if (GPA > 5){
			grossSalary = super.getGrossSalary();
		} else {
			grossSalary = 0;
		}
		
		return grossSalary;
		
	}
	public double getNetSalary() {
		return getGrossSalary();
	}
	
	public double getGrossSalaryNoBonus() {
		return getGrossSalary();
	}
	
	
	
	public String toString() {
		final String END_OF_LINE = System.lineSeparator();
		String Info = getName() + " has a gross salary of " + String.format("%.0f",getGrossSalary()) + " SEK with a " + getGPA() + " GPA"+ END_OF_LINE;
		return Info;
	}
	
}
