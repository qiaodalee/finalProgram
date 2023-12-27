package HW2;

import java.util.Scanner;

public class FullTimeEmployee extends Employee {
	private int basePayment;
    private double overtimeWorkHours;
    private int overtimeWorkHoursPay;
    
    public FullTimeEmployee() {

    }
    
    public FullTimeEmployee(String firstName, String lastName, String employeeId, int basePayment, double overtimeWorkHours, int overtimeWorkHoursPay) {
        super(firstName, lastName, employeeId, 0);
        this.basePayment = basePayment;
        this.overtimeWorkHours = overtimeWorkHours;
        this.overtimeWorkHoursPay = overtimeWorkHoursPay;
    }
    
    public void setBasePayment(int basePayment) {
    	this.basePayment = basePayment;
    }
    
    public int getBasePayment() {
    	return basePayment;
    }
    
    public void setOvertimeWorkHours(double overtimeWorkHours) {
    	this.overtimeWorkHours = overtimeWorkHours;
    }
    
    public double getOvertimeWorkHours() {
    	return overtimeWorkHours;
    }
    
    public void setOvertimeWorkHoursPay(int overtimeWorkHoursPay) {
    	this.overtimeWorkHoursPay = overtimeWorkHoursPay;
    }
    
    public int getOvertimeWorkHoursPay() {
    	return overtimeWorkHoursPay;
    }
    
    @Override
    public void print() {
        super.print();
        System.out.println("Base Payment: " + basePayment);
        System.out.println("Overtime Work Hours: " + overtimeWorkHours);
        System.out.println("Overtime Hour Pay: " + overtimeWorkHoursPay);
    }
    
    public FullTimeEmployee scan(Scanner scan) {
    	System.out.println("---------------Input FullTimeEmployee Information ------------");
        System.out.print("First Name: ");
        this.setFirstName(scan.next());
        System.out.print("Last Name: ");
        this.setLastName(scan.next());
        System.out.print("Employee ID: ");
        this.setEmployeeId(scan.next());
        System.out.print("Base payment: ");
        this.setBasePayment(scan.nextInt());
        System.out.print("Overtime work hours: ");
        this.setOvertimeWorkHours(scan.nextDouble());
        System.out.print("Overtime work hour pay: ");
        this.setOvertimeWorkHoursPay(scan.nextInt());
        return this;
    }
    
    public void computeMonthlySalary() {
    	setMonthlySalary(((int)(basePayment + overtimeWorkHours * overtimeWorkHoursPay)));
    }
}
