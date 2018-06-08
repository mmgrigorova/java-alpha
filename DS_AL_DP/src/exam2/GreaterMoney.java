package exam2;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class GreaterMoney {
    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        String[] inputS = in.nextLine().split(",");
        int[] bag1 = new int[inputS.length];

        for (int i = 0; i < bag1.length; i++) {
            bag1[i] = Integer.parseInt(inputS[i]);
        }

        String[] inputS2 = in.nextLine().split(",");
        int[] bag2 = new int[inputS2.length];

        for (int i = 0; i < bag2.length; i++) {
            bag2[i] = Integer.parseInt(inputS2[i]);
        }


        int[] greaterMoney = nextGreaterElement(bag1, bag2);
        for (int i = 0; i < greaterMoney.length; i++) {
            System.out.printf("%d", greaterMoney[i]);
            if (i == greaterMoney.length-1){
                break;
            }
            System.out.printf(",");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> values = new HashMap<>(); // To contain the answers
        Stack<Integer> lesserElems = new Stack<>(); // To contain decreasing sequence of numbers

        for (int num : nums2) {
            while (!lesserElems.empty() && num > lesserElems.peek()) {
                values.put(lesserElems.pop(), num);
            }
            lesserElems.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = values.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    private static void fakeInput() {
        String test = "5,2,3,4,1,8\n" +
                "1,2,3,4";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
