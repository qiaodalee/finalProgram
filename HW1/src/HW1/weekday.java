package HW1;


import java.util.Scanner;

public class weekday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Input weekday（String）： ");
        String weekdayName = scanner.nextLine();
        
        int weekdayNumber = getWeekdayNumber(weekdayName.toLowerCase());
        
        if (weekdayNumber != 0) {
            System.out.println("Output: " + weekdayName + " " + weekdayNumber);
        } else {
            System.out.println("Error: invalid week day name");
        }
        scanner.close();
	}
	
	 public static int getWeekdayNumber(String weekdayName) {
	        int weekdayNumber;
	        switch (weekdayName) {
	            case "monday":
	                weekdayNumber = 1;
	                break;
	            case "tuesday":
	                weekdayNumber = 2;
	                break;
	            case "wednesday":
	                weekdayNumber = 3;
	                break;
	            case "thursday":
	                weekdayNumber = 4;
	                break;
	            case "friday":
	                weekdayNumber = 5;
	                break;
	            case "saturday":
	                weekdayNumber = 6;
	                break;
	            case "sunday":
	                weekdayNumber = 7;
	                break;
	            default:
	            	// Invalid weekday name
	                weekdayNumber = 0;
	                break;
	        }
	        return weekdayNumber;
	    }

}
