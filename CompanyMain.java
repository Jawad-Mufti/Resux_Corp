package Company;

import java.util.Scanner;

public class CompanyMain {
	Scanner input = new Scanner(System.in);
	ReusaxCorp Employee = new ReusaxCorp();

	public void run() {
		int option;
		do {
			menu();
			System.out.print(" Type the option number: ");

			option = input.nextInt();
			input.nextLine(); // this skips the enter
								// that the user types after
								// typing the integer option.

			switch (option) {
			case 1:

				registerEmployee();

				break;

			case 2:

				System.out.println("Input the employee ID");
				String ID = input.nextLine();
				if (Employee.checkList(ID) == true) {
					Employee.removeEmployee(ID);
					System.out.println("Employee with the id " + ID + " has been fired.");
				} else {
					System.out.println("An employee of ID " + ID + " is not registered in the system.");
				}

				break;

			case 3:
				System.out.println("Input employee ID");
				ID = input.nextLine();

				if (Employee.checkList(ID) == true) {
					Employee.retrieve(ID);
				} else {
					System.out.println("An employee of ID " + ID + " is not registered in the system.");
				}

				break;

			case 4:

				updateEmployee();

				break;

			case 5:
				Employee.calculateExp();
				break;

			case 6:

				Employee.calculateNetSalaries();
				break;

			case 7:
				Employee.numEmployees();
				Employee.sortArray();

				break;

			case 8:
				System.out.println("Thank you for using ReusaxCorp Admin Panel.");
				System.out.println();
				break;

			default:
				System.out.println("Option " + option + " is not valid.");
				System.out.println();
				break;
			}
		} while (option != 8);

	}

	public void registerEmployee() {
		int employeeOption;

		System.out.println("1. Register a Regular Employee");
		System.out.println("2. Register a Manager ");
		System.out.println("3. Register Director");
		System.out.println("4. Register Intern");

		employeeOption = input.nextInt();
		input.nextLine();
		switch (employeeOption) {
		case 1:
			System.out.println("Register employee's name?");

			String Name = input.nextLine();

			System.out.println("Register employee's ID?");
			String ID = input.nextLine();

			System.out.println("Register employee's Salary?");
			double GrossSalary = input.nextDouble();

			Employee.addRegular(Name, ID, GrossSalary);
			break;

		case 2:
			System.out.println("Register manager's name?");

			Name = input.nextLine();

			System.out.println("Register employee's ID?");
			ID = input.nextLine();

			System.out.println("Register employee's Salary?");
			GrossSalary = input.nextDouble();
			input.nextLine();

			System.out.println("Does the manager have a BSc, MSc or PhD Degree?");
			String Degree = input.nextLine();

			Employee.addManager(Name, ID, GrossSalary, Degree);

			break;

		case 3:
			System.out.println("Register director's name?");

			Name = input.nextLine();

			System.out.println("Register director's ID?");
			ID = input.nextLine();

			System.out.println("Register director's Salary?");
			GrossSalary = input.nextDouble();
			input.nextLine();

			System.out.println("Does the manager have a BSc, MSc or PhD Degree?");
			Degree = input.nextLine();

			System.out.println("Does the director work in the Human Resources, Technical or Business Department?");
			String Department = input.nextLine();

			Employee.addDirector(Name, ID, GrossSalary, Degree, Department);
			break;

		case 4:
			System.out.println("Register intern's name?");

			Name = input.nextLine();

			System.out.println("Register intern's ID?");
			ID = input.nextLine();

			System.out.println("Register intern's Salary?");
			GrossSalary = input.nextDouble();
			input.nextLine();

			System.out.println("Register intern's GPA?");
			int GPA = input.nextInt();

			Employee.addIntern(Name, ID, GrossSalary, GPA);
			break;

		default:
			System.out.println("Option " + employeeOption + " is not valid.");
			System.out.println();
			break;
		}

	}

	public void updateEmployee() {

		int updateOption;

		System.out.println("1. Update the name of the employee. ");
		System.out.println("2. Update the salary of the employee. ");
		System.out.println("3. Update the directors benefit. ");
		System.out.println("4. Make employee regular Employee");
		System.out.println("5. Make employee manager");
		System.out.println("6. Make employee director");
		System.out.println("7. Make employee intern");

		updateOption = input.nextInt();
		input.nextLine();
		switch (updateOption) {

		case 1:
			System.out.println("Input the ID of the employee you want to edit.");
			String ID = input.nextLine();
			if (Employee.checkList(ID) == true) {
				System.out.println("What do you want the new name of the employee to be?");
				String newName = input.nextLine();
				Employee.updateName(newName, ID);
			} else {
				System.out.println("An employee of ID " + ID + " is not registered in the system.");
			}
			break;

		case 2:
			System.out.println("Input the ID of the employee you want to edit.");
			ID = input.nextLine();
			if (Employee.checkList(ID) == true) {
				System.out.println("What do you want the new salary of the employee to be?");
				double newSalary = input.nextDouble();
				Employee.updateSalary(newSalary, ID);

			} else {
				System.out.println("An employee of ID " + ID + " is not registered in the system.");
			}

		case 3:
			System.out.println("What do you want the new director's benefit to be?");
			double newBenefit = input.nextDouble();
			Director.setBenefit(newBenefit);
			break;
		case 4:
			System.out.println("Enter id of the employee you want to promote.");
			ID = input.nextLine();
			if (Employee.checkList(ID) == true) {
				Employee.promoteRegular(ID);
			} else {
				System.out.println("An employee of ID " + ID + " is not registered in the system.");
			}

			break;

		case 5:
			System.out.println("Enter id of the employee you want to promote.");
			ID = input.nextLine();
			if (Employee.checkList(ID) == true) {
				System.out.println("Enter the degree of the employee you want to promote.");
				String Degree = input.nextLine();
				if (Employee.checkDegree(Degree) == true) {
					Employee.promoteManager(ID, Degree);
				}
			} else {
				System.out.println("An employee of ID " + ID + " is not registered in the system.");
			}
			break;

		case 6:

			System.out.println("Enter id of the employee you want to promote.");
			ID = input.nextLine();
			if (Employee.checkList(ID) == true) {
				System.out.println("Enter the degree of the employee you want to promote.");
				String Degree = input.nextLine();
				if (Employee.checkDegree(Degree) == true) {
					System.out.println("Enter the department of the employee you want to promote.");
					String Department = input.nextLine();
					if (Employee.checkDepartment(Department) == true) {
						Employee.promoteDirector(ID, Degree, Department);
					}
				}
			} else {
				System.out.println("An employee of ID " + ID + " is not registered in the system.");
			}
			break;

		case 7:

			System.out.println("Enter id of the employee you want to promote.");
			ID = input.nextLine();
			if (Employee.checkList(ID) == true) {
			System.out.println("Enter the GPA of the employee you want to promote.");
			int GPA = input.nextInt();
			Employee.promoteIntern(ID, GPA);
			} else {
				System.out.println("An employee of ID " + ID + " is not registered in the system.");
			}
			break;

		default:
			System.out.println("Option " + updateOption + " is not valid.");
			System.out.println();
			break;
		}

	}

	private static void menu() {
		System.out.println(" === Welcome to ReusaxCorp === ");
		System.out.println(" Choose an option below: ");
		System.out.println(" ");
		System.out.println(" 1. Register an employee. ");
		System.out.println(" 2. Remove an employee. ");
		System.out.println(" 3. Retrieve an employee. ");
		System.out.println(" 4. Update employees. ");
		System.out.println(" 5. Gross salaries. ");
		System.out.println(" 6. Net salaries ");
		System.out.println(" 7. List of employees (sorted)");
		System.out.println(" 8. Quit ");
	}

	public static void main(String[] args) {
		CompanyMain program = new CompanyMain();
		program.run();
	}
}