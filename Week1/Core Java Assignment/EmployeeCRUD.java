
import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "%d. name='%s', department='%s'".formatted(id, name, department);
    }
}

public class EmployeeCRUD {
    private List<Employee> employees_list;

    public EmployeeCRUD() {
        this.employees_list = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees_list.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees_list;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees_list) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(int id, String name, String department) {
        for (Employee employee : employees_list) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setDepartment(department);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void deleteEmployee(int id) {
        for (Employee employee : employees_list) {
            if (employee.getId() == id) {
                employees_list.remove(employee);
                System.out.println("Employee with ID " + id + " deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void printAllEmployees() {
        for (Employee employee : employees_list) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        employeeCRUD.addEmployee(new Employee(33, "Verstappen", "Data"));
        employeeCRUD.addEmployee(new Employee(44, "Hamilton", "Software"));
        employeeCRUD.addEmployee(new Employee(5, "Vettel", "IT"));

        List<Employee> allEmployees = employeeCRUD.getAllEmployees();
        System.out.println("> Employees in DB are:");
        employeeCRUD.printAllEmployees();

        Employee foundEmployee = employeeCRUD.getEmployeeById(44);
        if (foundEmployee != null) {
            System.out.println(foundEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        employeeCRUD.updateEmployee(33, "Max Verstappen", "Quant");
        System.out.println("> Update Complete");

        employeeCRUD.deleteEmployee(44);
        System.out.println("> Delete Complete");

        System.out.println("> Final Employee DB");
        employeeCRUD.printAllEmployees();
    }
}