package HW2;

import java.util.Scanner;

public class Employee {
	private String firstName;
    private String lastName;
    private String employeeId;
    private int monthlySalary;
    
    public Employee() {
    }

    public Employee(String firstName, String lastName, String employeeId, int monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.monthlySalary = monthlySalary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }
    
    public void print() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Monthly Salary: " + monthlySalary);
    }
    
    public Employee scan(Scanner scan) {
    	System.out.println("---------------Input Employee Information ------------");
        System.out.print("First Name: ");
        this.setFirstName(scan.next());
        System.out.print("Last Name: ");
        this.setLastName(scan.next());
        System.out.print("Employee ID: ");
        this.setEmployeeId(scan.next());
        System.out.print("Monthly Salary: ");
        this.setMonthlySalary(scan.nextInt());
        return this;
    }
}
