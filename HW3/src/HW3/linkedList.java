package HW3;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class linkedList {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter k: ");
        int k = scan.nextInt();

        LinkedList<Number> numbersList = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            System.out.print((i + 1) + ": ");
            numbersList.add(scan.nextDouble());
        }

        double sum = 0;
        Iterator<Number> iterator = numbersList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().doubleValue();
        }
        double average = sum / k;

        System.out.println("LinkedList: " + numbersList);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scan.close();
    }

}
