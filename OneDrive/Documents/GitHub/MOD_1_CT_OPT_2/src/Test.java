import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Get employee details
        System.out.println("Enter Employee Details:");
        Employee employee = getEmployeeDetails(scanner);

        // Get manager details
        System.out.println("\nEnter Manager Details:");
        Manager manager = getManagerDetails(scanner);

        // Close the Scanner object
        scanner.close();

        // Print employee and manager summaries
        System.out.println("\nEmployee Summary:");
        employee.employeeSummary();

        System.out.println("\nManager Summary:");
        manager.employeeSummary();
    }

    // Method to get employee details from user input
    private static Employee getEmployeeDetails(Scanner scanner) {
        Employee employee = new Employee();
        System.out.print("Enter first name: ");
        employee.setFirstName(scanner.nextLine());
        System.out.print("Enter last name: ");
        employee.setLastName(scanner.nextLine());
        System.out.print("Enter employee ID: ");
        employee.setEmployeeID(scanner.nextInt());
        System.out.print("Enter salary: ");
        employee.setSalary(scanner.nextDouble());
        scanner.nextLine(); // Consume newline character
        return employee;
    }

    // Method to get manager details from user input
    private static Manager getManagerDetails(Scanner scanner) {
        Manager manager = new Manager();
        System.out.print("Enter first name: ");
        manager.setFirstName(scanner.nextLine());
        System.out.print("Enter last name: ");
        manager.setLastName(scanner.nextLine());
        System.out.print("Enter employee ID: ");
        manager.setEmployeeID(scanner.nextInt());
        System.out.print("Enter salary: ");
        manager.setSalary(scanner.nextDouble());
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter department: ");
        manager.setDepartment(scanner.nextLine());
        return manager;
    }
}
