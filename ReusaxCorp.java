package Company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReusaxCorp {

	ArrayList<Employee> employees;

	public ReusaxCorp() {

		this.employees = new ArrayList<Employee>();

	}

	public void sortArray() {

		Collections.sort(employees, new Comparator<Employee>() {
			public int compare(Employee emp1, Employee emp2) {

				int comparasion = 0;
				comparasion = emp1.getName().compareTo(emp2.getName());
				if (comparasion == 0) {
					comparasion = Double.compare(emp1.getGrossSalaryNoBonus(), (emp2.getGrossSalaryNoBonus()));
				}
				return comparasion;

			}
		});

		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).getName() + " " + employees.get(i).getGrossSalaryNoBonus() + " SEK");
		}
	}

	public void addRegular(String Name, String ID, double GrossSalary) {

		Employee emp = new RegularEmployee(Name, ID, GrossSalary);
		if (checkList(ID) == true) {
			System.out.println("An employee with this ID already exist");
		} else {
			this.employees.add(emp);

		}
	}

	public void addManager(String Name, String ID, double GrossSalary, String Degree) {

		Employee emp = new Manager(Name, ID, GrossSalary, Degree);
		if (checkList(ID) == false) {
			if (checkDegree(Degree) == true) {
				this.employees.add(emp);
			}

		} else {
			System.out.println("An employee with this ID already exist");

		}
	}

	public void addDirector(String Name, String ID, double GrossSalary, String Degree, String Department) {

		Employee emp = new Director(Name, ID, GrossSalary, Degree, Department);
		if (checkList(ID) == false) {
			if (checkDegree(Degree) == true) {
				if (checkDepartment(Department) == true) {
					this.employees.add(emp);
				}
			}

		} else {
			System.out.println("An employee with this ID already exist");

		}
	}

	public void addIntern(String Name, String ID, double GrossSalary, int GPA) {

		Employee emp = new Intern(Name, ID, GrossSalary, GPA);
		if (checkList(ID) == false) {
			if(GPA >= 0 && GPA <= 10) {
				this.employees.add(emp);
			} else {
				System.out.println("The GPA must be a number between 0-10");
			}
			
			
		} else {
			System.out.println("An employee with this ID already exist");

		}
	}
	
	// This is good/safe (upcast) - because all types of employees have the behaviors of a regularEmployee
	public void promoteRegular(String ID) {

		String Name = this.employees.get(checkID(ID)).getName();
		double GrossSalary = this.employees.get(checkID(ID)).getGrossSalaryNoBonus();

		Employee emp = new RegularEmployee(Name, ID, GrossSalary);
		this.employees.remove(checkID(ID));
		this.employees.add(emp);

	}
	// This is not good (downcast) - because all types of employees does not have the behaviors of a Manager and even the ones that do like "director" we still need to ask for degree again.
	public void promoteManager(String ID, String Degree) {

		String Name = this.employees.get(checkID(ID)).getName();
		double GrossSalary = this.employees.get(checkID(ID)).getGrossSalaryNoBonus();

		Employee emp = new Manager(Name, ID, GrossSalary, Degree);
		this.employees.remove(checkID(ID));
		this.employees.add(emp);
	}
	
	// This is not good (downcast) - because all types of employees does not have the behaviors of a director, manager has a degree but we still ask for degree. Otherwise we would have to check if we are promoting a manger or intern or regularemployee.
	public void promoteDirector(String ID, String Degree, String Department) {
		String Name = this.employees.get(checkID(ID)).getName();
		double GrossSalary = this.employees.get(checkID(ID)).getGrossSalaryNoBonus();

		Employee emp = new Director(Name, ID, GrossSalary, Degree, Department);
		this.employees.remove(checkID(ID));
		this.employees.add(emp);
	}

	// downcast aswell but not as bad as manager/director because the only type of employee that can have GPA is "intern" so we just need to specify the GPA when we promote/demote an employee to intern.
	public void promoteIntern(String ID, int GPA) {

		String Name = this.employees.get(checkID(ID)).getName();
		double GrossSalary = this.employees.get(checkID(ID)).getGrossSalaryNoBonus();

		Employee emp = new Intern(Name, ID, GrossSalary, GPA);
		this.employees.remove(checkID(ID));
		this.employees.add(emp);
	}

	public void removeEmployee(String ID) {

		this.employees.remove(checkID(ID));

	}

	public void updateName(String name, String ID) {

		employees.get(checkID(ID)).setName(name);

	}

	public void updateSalary(double salary, String ID) {

		employees.get(checkID(ID)).setSalary(salary);

	}

	public void retrieve(String ID) {

		System.out.println(employees.get(checkID(ID)).toString());

	}

	public double calculateExp() {
		double total = 0;
		for (int i = 0; i < employees.size(); i++) {

			total = total + this.employees.get(i).getGrossSalary();

		}
		System.out.println(
				"Every month the company pays out " + String.format("%.0f", total) + " SEK in gross salaries.");
		return total;

	}

	public double calculateNetSalaries() {
		double total = 0;
		for (int i = 0; i < employees.size(); i++) {

			total = total + this.employees.get(i).getNetSalary();

		}
		System.out.println(
				"Every month the total net salaries of the employees are " + String.format("%.0f", total) + " SEK ");
		return total;
	}

	public int numEmployees() {

		int total = 0;
		total = total + employees.size();

		System.out.println("There is " + total + " employees in the company:");
		return total;

	}

	public int checkID(String ID) {

		for (int i = 0; i < employees.size(); i++) {

			if (employees.get(i).getID().equalsIgnoreCase(ID)) {
				return i;

			}

		}
		return -1;
	}

	public boolean checkList(String ID) {
		boolean check = false;
		for (int i = 0; i < employees.size(); i++) {

			if (employees.get(i).getID().equalsIgnoreCase(ID)) {
				check = true;

			}

		}
		return check;
	}

	public boolean checkDegree(String Degree) {
		boolean check = false;

		if ("BSc".equalsIgnoreCase(Degree) || "MSc".equalsIgnoreCase(Degree) || "PhD".equalsIgnoreCase(Degree)) {
			check = true;

		} else {
			System.out.println("The degree must be a BSc, MSc or PhD");
		}
		return check;
	}

	public boolean checkDepartment(String Department) {
		boolean check = false;

		if ("Human Resources".equalsIgnoreCase(Department) || "Technical".equalsIgnoreCase(Department)
				|| "Business".equalsIgnoreCase(Department)) {
			check = true;

		}
		return check;
	}

}
