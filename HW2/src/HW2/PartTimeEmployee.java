package HW2;

import java.util.Scanner;

public class PartTimeEmployee extends Employee {
	private double workingHours;
    private int hourPay;
    
    public PartTimeEmployee() {

    }
    
    public PartTimeEmployee(String firstName, String lastName, String employeeId, double workingHours, int hourPay) {
        super(firstName, lastName, employeeId, 0);
        this.workingHours = workingHours;
        this.hourPay = hourPay;
    }
    
    public void setWorkingHours(double workingHours) {
    	this.workingHours = workingHours;
    }
    
    public double getWorkingHours() {
    	return workingHours;
    }
    
    public void setHourPay(int hourPay) {
    	this.hourPay = hourPay;
    }
    
    public double getHourPay() {
    	return hourPay;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Working Hours: " + workingHours);
        System.out.println("Hour Pay: " + hourPay);
    }
    
    public PartTimeEmployee scan(Scanner scan) {
    	System.out.println("---------------Input PartTimeEmployee Information ------------");
        System.out.print("First Name: ");
        this.setFirstName(scan.next());
        System.out.print("Last Name: ");
        this.setLastName(scan.next());
        System.out.print("Employee ID: ");
        this.setEmployeeId(scan.next());
        System.out.print("Work hours: ");
        this.setWorkingHours(scan.nextDouble());
        System.out.print("Hour pay: ");
        this.setHourPay(scan.nextInt());
        return this;
    }

    public void computeMonthlySalary() {
        setMonthlySalary(((int)(workingHours * hourPay)));
    }
}
