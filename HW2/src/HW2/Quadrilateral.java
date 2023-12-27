package HW2;

public class Quadrilateral {
	public class Point {
        private int x;
        private int y;
        
        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    
    public Quadrilateral() {
    }

    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public void printCoordinates() {
        System.out.println("Coordinates of the four vertices:");
        System.out.println("Point 1: (" + point1.getX() + ", " + point1.getY() + ")");
        System.out.println("Point 2: (" + point2.getX() + ", " + point2.getY() + ")");
        System.out.println("Point 3: (" + point3.getX() + ", " + point3.getY() + ")");
        System.out.println("Point 4: (" + point4.getX() + ", " + point4.getY() + ")");
    }
}
