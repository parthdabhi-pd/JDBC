public class Query {
    public static final String INSERT_EMPLOYEE = "INSERT INTO Employee (name, age, department, salary) VALUES (?, ?, ?, ?)";
    public static final String GET_ALL_EMPLOYEES = "SELECT * FROM Employee";
    public static final String UPDATE_EMPLOYEE = "UPDATE Employee SET name = ?, age = ?, department = ?, salary = ? WHERE id = ?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE id = ?";
}
