package HW1;


import java.util.Scanner;

public class triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Input the number of rows: ");
        int k = scanner.nextInt();

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= (k - i); j++) {
            	//space in front
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
            	//numerical increase
            	//1 -> maximum
                System.out.print(j + " ");
            }

            for (int j = i - 1; j >= 1; j--) {
            	//numerical decrease
            	//maximum-1 -> 1
                System.out.print(j + " ");
            }

            System.out.println();
        }
        scanner.close();
	}
}
