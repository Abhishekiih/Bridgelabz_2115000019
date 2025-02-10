import java.util.*;

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    public double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    public double calculateSalary() {
        return hourlyRate * workHours;
    }

    public void assignDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(1, "Alice", 50000);
        Employee emp2 = new PartTimeEmployee(2, "Bob", 100, 120);
        ((FullTimeEmployee) emp1).assignDepartment("HR");
        ((PartTimeEmployee) emp2).assignDepartment("IT");
        emp1.displayDetails();
        emp2.displayDetails();
    }
}
