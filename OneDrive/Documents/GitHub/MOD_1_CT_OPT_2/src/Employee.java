
public class Employee {

	    private String firstName;
	    private String lastName;
	    private int employeeID;
	    private double salary;

	    // Constructor
	    public Employee() {
	        this.salary = 0.0;
	    }

	    // Setters
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public void setEmployeeID(int employeeID) {
	        this.employeeID = employeeID;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

	    // Getters
	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public int getEmployeeID() {
	        return employeeID;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    // Method to print employee summary
	    public void employeeSummary() {
	        System.out.println("Employee ID: " + employeeID);
	        System.out.println("First Name: " + firstName);
	        System.out.println("Last Name: " + lastName);
	        System.out.println("Salary: $" + salary);
	    }
	}



