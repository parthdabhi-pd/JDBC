import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter department: ");
                    String department = scanner.next();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    Employee newEmployee = new Employee(name, age, department, salary);
                    employeeDAO.addEmployee(newEmployee);
                    break;

                case 2:
                    employeeDAO.getAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new department: ");
                    String newDepartment = scanner.next();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();

                    Employee updatedEmployee = new Employee(idToUpdate, newName, newAge, newDepartment, newSalary);
                    employeeDAO.updateEmployee(updatedEmployee);
                    break;

                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    employeeDAO.deleteEmployee(idToDelete);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
