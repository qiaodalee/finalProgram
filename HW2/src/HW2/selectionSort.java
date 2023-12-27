package HW2;

import java.util.Scanner;

public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of k: ");
        int k = scanner.nextInt();

        Integer[] integers = new Integer[k];

        for (int i = 0; i < k; i++) {
        	System.out.print(i + ": " );
            integers[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        System.out.print("Unsorted order: ");
        for (Integer num : integers) {
            System.out.print(num + " ");
        }
        

        sort(integers);

        System.out.print("\nSorted order: ");
        for (Integer num : integers) {
            System.out.print(num + " ");
        }
    }

    public static void sort(Integer[] integers) {
        int n = integers.length;

        for (int i = 0; i < n-1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (integers[j].compareTo(integers[min]) < 0) {
                	min = j;
                }
            }

            Integer temp = integers[i];
            integers[i] = integers[min];
            integers[min] = temp;
        }
	}

}
