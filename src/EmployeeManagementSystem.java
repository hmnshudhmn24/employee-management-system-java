import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Department: " + department + " | Salary: $" + salary;
    }
}

public class EmployeeManagementSystem {
    private static final List<Employee> employees = new ArrayList<>();
    private static int employeeCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Remove Employee");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee(scanner);
                case 2 -> viewEmployees();
                case 3 -> removeEmployee(scanner);
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Employee employee = new Employee(employeeCounter++, name, department, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees recorded.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void removeEmployee(Scanner scanner) {
        if (employees.isEmpty()) {
            System.out.println("No employees to remove.");
            return;
        }
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        employees.removeIf(employee -> employee.id == id);
        System.out.println("Employee removed successfully!");
    }
}
