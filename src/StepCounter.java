import java.util.Scanner;

public class StepCounter {

	public static void main(String[] args) {
		//Step Counter
        Scanner in = new Scanner(System.in);
        int steps = in.nextInt();
		in.close();

        final int milesFactor = 1609;
        if(steps >=1 && steps <= 10000) {
            System.out.print(steps * milesFactor);
        }else{
            System.out.println("invalid input");
        }
	}

}
