package HW2;

import java.util.Scanner;
import java.util.ArrayList;

public class TestEmployee {
	public static void main(String[] args) {
		Employee employee_default = new Employee("Matt", "Lee", "A001", 85000);

        System.out.println("Default Employee Information:");
        employee_default.print();
        
		ArrayList <Employee> employees = new ArrayList<>();
        String cont = "Y";
        Scanner scan = new Scanner(System.in);
        while ( cont.equalsIgnoreCase("y")) {
        	Employee employee = new Employee();
        	employee = employee.scan(scan);
        	employees.add(employee);
        	System.out.print("Input next?(y/n): ");
        	cont = scan.next();
        }
        scan.close();
        
        for (Employee e: employees) {
        	System.out.println("---------------Show Employee Information ------------");
        	e.print();
        }
    }
}
