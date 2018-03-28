package Conditionals;
import java.util.Scanner;
/*
 * Един ден на местния панаир си купил една огромна кутия с N колби, които били еднакви по форма и цвят, 
 * но всяка следваща била по-голяма от предишните. На дъното на всяка от тях били изписани 
 * последователно числата от 1 до N. 
 * В първaта колба никога не поставяй нищо, тъй като колкото и да наливаш в нея тя ще е винаги празна. 
 * Всяка следваща колба събира толкова литри, колкото ако към номера на предишната колба прибавиш литрите, 
 * които събира предходната колба. И помни – счупиш ли колба с нечетен номер няма да се случи нищо, 
 * но счупиш ли колба с четен номер всички колби с четни номера ще изчезнат ”.
 */

public class Kolbi {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long l = input.nextLong();
		long tempL = 0;
		input.close();

		if(n>1 && n<= 1000000) {
			for (int i=1; i <= n; i++) {
				System.out.println(i + " " + tempL);
				if (tempL >= l){
					if(i%2 != 0) {
						System.out.println(i);
						break;
					} else if(i+1 <= n){
						System.out.println(i+1);
						break;
					} 
				}
				tempL = i + tempL;
			}
		}

	}

}

