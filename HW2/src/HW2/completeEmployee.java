package HW2;

import java.util.Scanner;
import java.util.ArrayList;

public class completeEmployee {
	public static void main(String[] args) {
		FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Matt", "Lee", "A001", 36000, 30, 200);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jennessa", "Chang", "A002", 120, 200);

        fullTimeEmployee.computeMonthlySalary();
        partTimeEmployee.computeMonthlySalary();

        System.out.println("Default fullTimeEmployee Information:");
        fullTimeEmployee.print();

        System.out.println("\nDefault partTimeEmployee Information:");
        partTimeEmployee.print();
        
        ArrayList <FullTimeEmployee> fullTimeEmployees = new ArrayList<>();
        ArrayList <PartTimeEmployee> partTimeEmployees = new ArrayList<>();
        int slc = 1;
        Scanner scan = new Scanner(System.in);
        System.out.print("Input next?\n0 to quit, 1 to fullTimeEmployees, 2 to partTimeEmployees: ");
    	slc = scan.nextInt();
        while ( slc == 1 || slc == 2) {
        	if (slc == 1) {
        		FullTimeEmployee employee = new FullTimeEmployee();
            	employee = employee.scan(scan);
            	employee.computeMonthlySalary();
            	fullTimeEmployees.add(employee);
        	}
        	else {
        		PartTimeEmployee employee = new PartTimeEmployee();
            	employee = employee.scan(scan);
            	employee.computeMonthlySalary();
            	partTimeEmployees.add(employee);
        	}
        	
        	System.out.print("Input next?\n0 to quit, 1 to fullTimeEmployees, 2 to partTimeEmployees: ");
        	slc = scan.nextInt();
        }
        scan.close();
        
        for (FullTimeEmployee e: fullTimeEmployees) {
        	System.out.println("---------------Show FullTimeEmployee Information ------------");
        	e.print();
        }
        for (PartTimeEmployee e: partTimeEmployees) {
        	System.out.println("---------------Show PartTimeEmployee Information ------------");
        	e.print();
        }
	}
}
