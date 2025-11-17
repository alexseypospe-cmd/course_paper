import java.util.Objects;

public class Employee {
    private static int idCounter = 1;

    // Поля класса (скрыты от прямого доступа)
    private final int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = idCounter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }
    @Override
    public String toString() {
        return "id =" + id +
                ", fullName = " + fullName + '\'' +
                ", department = " + department +
                ", salary= " + salary;
    }
    public void printShortInfo() {
        System.out.println("Name: " + fullName + ", Salary: " + salary);
    }
}
