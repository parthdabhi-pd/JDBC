import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        try (Connection connection = Database.getConnection();
             PreparedStatement ps = connection.prepareStatement(Query.INSERT_EMPLOYEE)) {

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Employee added successfully!" : "Failed to add employee.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllEmployees() {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Query.GET_ALL_EMPLOYEES)) {

            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
            }

            if (employees.isEmpty()) {
                System.out.println("No employees found.");
            } else {
                employees.forEach(System.out::println);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        try (Connection connection = Database.getConnection();
             PreparedStatement ps = connection.prepareStatement(Query.UPDATE_EMPLOYEE)) {

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getId());

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Employee updated successfully!" : "Failed to update employee.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement ps = connection.prepareStatement(Query.DELETE_EMPLOYEE)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Employee deleted successfully!" : "Failed to delete employee.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
