package Arrays;
import java.util.Scanner;
//https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm_(Algorithm_3:_Dynamic_Programming)
public class LongesIncreasingSequence {

	public static void main(String[] args) {

			Scanner in = new Scanner (System.in);
			int n = in.nextInt();
			 int[] array = new int[n];
			
			for(int i = 0; i<n; i++) {
				array[i] = in.nextInt();
			}
//			int n = 10;
//			int[] array= {2,3,-6,-1,2,-1,6,4,-8,8};
			in.close();
			
			int accumulator = array[0]; //max_so_far
			int maxEnd = array[0]; //max_ending_here
			
			for(int i = 1; i < n; i++) {				
				maxEnd = Math.max(array[i], maxEnd+array[i]);
				accumulator = Math.max(maxEnd, accumulator);
			}
			System.out.println(accumulator);

	}

}
