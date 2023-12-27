package HW3;

import java.util.Arrays;
import java.util.Scanner;

public class selectionSort {

    public static <T extends Comparable<T>> void doSelectionSort(T[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static <T> void printArray(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
        Integer[] intArr = new Integer[5];
        int element = 0;
        int index = 0;
        System.out.println("\nEnter 5 integer");
        while(index < 5) {
        	System.out.print((index+1)+": ");
        	element = scan.nextInt();
        	intArr[index] = element;
        	index++;
        }
        
        System.out.print("\nBefore: ");
        printArray(intArr);

        doSelectionSort(intArr);
        System.out.print("\nAfter: ");
        printArray(intArr);

        Double[] doubleArr = new Double[5];
        Double dElement = 0.0;
        index = 0;
        System.out.println("\nEnter 5 double");
        while(index < 5) {
        	System.out.print((index+1)+": ");
        	dElement = scan.nextDouble();
        	doubleArr[index] = dElement;
        	index++;
        }
        
        System.out.print("\nBefore: ");
        printArray(doubleArr);

        doSelectionSort(doubleArr);
        System.out.print("\nAfter: ");
        printArray(doubleArr);
        
        scan.close();
    }

}
