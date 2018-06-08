package exam2;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Subsequence {
    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        String sub = in.nextLine();
        String full = in.nextLine();

        int index = 0;
        boolean isSubsequence = isSubsequence(sub, full);

        System.out.println(isSubsequence);
    }

    private static boolean isSubsequence(String sub, String full) {
        if (sub.length() == 0) {
            return true;
        }

        int indexSub = 0;
        int indexFull = 0;

        while (indexSub <= indexFull) {
            if (sub.charAt(indexSub) == full.charAt(indexFull)) {
                indexSub += 1;
                if (indexSub == sub.length()){
                    return true;
                }
            }
            indexFull += 1;
            if(indexFull == full.length()){
                return false;
            }
        }

        return false;
    }


    private static void fakeInput() {
        String test = "koci\n" +
                "kociokkociiev";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}
