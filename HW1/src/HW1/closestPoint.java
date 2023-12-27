package HW1;


import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class point{
	int x;
	int y;
	
	public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
	
	//compute the distance of point a and b.
    public double distance(point p) {
    	int disX = (this.x - p.x)*(this.x - p.x);
    	int disY = (this.y - p.y)*(this.y - p.y);
        return Math.sqrt(disX + disY);
    }

    //output
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

public class closestPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create the set to store points
		List<point> points = new ArrayList<>();
		System.out.println("other points");
		
		//random 5 points
		for (int i = 0; i < 5; i++) {
			point p = new point(new Random().nextInt(100), new Random().nextInt(100));
	        while ( points.indexOf(p) != -1) {
				p = new point(new Random().nextInt(100), new Random().nextInt(100));
	        }
	        points.add(p);
	        System.out.println(p.toString());
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input x(<100): ");
		int x = scanner.nextInt();
		while (x >= 100) {
			x = scanner.nextInt();
		}
		System.out.print("Input y(<100): ");
		int y = scanner.nextInt();
		while (y >= 100) {
			y = scanner.nextInt();
		}
		point target = new point(x, y);
		System.out.println("target points");
		System.out.println(target.toString());
		double closest = Integer.MAX_VALUE;
		point maxPoint = new point(0, 0);
		for ( point p:points) {
			System.out.println(p.toString() + " to " + target.toString() + " = " + p.distance(target));
			if ( p.distance(target) < closest) {
				maxPoint = p;
				closest = p.distance(target);
			}
		}
		System.out.println("closest point is " + maxPoint);
		scanner.close();
	}

}
