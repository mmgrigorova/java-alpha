package Conditionals;
import java.util.Scanner;

public class BonusScore {

	public static void main(String[] args) {
		 //Bonus Score
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if(n<1 || n>9){
            System.out.println("invalid score");
        } else if(n<4){
            System.out.println(n*10);
        } else if(n<7){
            System.out.println(n*100);
        } else {
            System.out.println(n*1000);
        }
        in.close();
	}
	
}
