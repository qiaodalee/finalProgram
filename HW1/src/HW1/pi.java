package HW1;


public class pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        for (int num = 1; num <= 10; num++) {
            int max = num * 10000;
            double pi = 0;
            for(double k = 1; k <= max; k++) {
            	if ( k % 2 == 0) {
            		pi -= 1/((2*k)-1);
            	}
            	else {
            		pi += 1/((2*k)-1);
            	}
            }
            pi = pi * 4;
            System.out.println("k = " + max + ", pi = " + pi);
        }
	}
}
