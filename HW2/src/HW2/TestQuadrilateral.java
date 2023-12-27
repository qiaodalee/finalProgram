package HW2;

import java.util.Scanner;
import java.util.ArrayList;

public class TestQuadrilateral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Input quadrilateral:");
		 Quadrilateral.Point point1 = new Quadrilateral().new Point();
		 Quadrilateral.Point point2 = new Quadrilateral().new Point();
		 Quadrilateral.Point point3 = new Quadrilateral().new Point();
		 Quadrilateral.Point point4 = new Quadrilateral().new Point();
		 ArrayList <Quadrilateral.Point> points = new ArrayList<>();
		 points.add(point1);
		 points.add(point2);
		 points.add(point3);
		 points.add(point4);
		 for (int i = 0; i< 4; i++) {
			 System.out.print("Input "+i+"-X:");
			 points.get(i).setX(scan.nextInt());
			 System.out.print("Input "+i+"-Y:");
			 points.get(i).setY(scan.nextInt());
		 }
		 scan.close();
		 
		 Quadrilateral quad = new Quadrilateral(
				 points.get(0),
				 points.get(1),
				 points.get(2),
				 points.get(3));
		 
		
        quad.printCoordinates();
	}

}
