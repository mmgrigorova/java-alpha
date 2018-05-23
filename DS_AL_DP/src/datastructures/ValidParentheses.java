package datastructures;

import java.util.*;

/**
 * Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public static void main(String[] args) {
//        String parentheses = "([)]";
//        String parentheses = "()";
//        String parentheses = "{[]}";
//        String parentheses = "((";
        String parentheses = "()[]{}";
        System.out.println(Solution.isValid(parentheses));
    }

    static class Solution {
        public static boolean isValid(String s) {
            if (s.isEmpty()) {
                return true;
            }

            if (s.length() % 2 != 0) {
                return false;
            }

            Stack<Character> lefts = new Stack<>();

            Map<Character, Character> match = new HashMap<>();
            match.put(')', '(');
            match.put('}', '{');
            match.put(']', '[');

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '(' || c == '{' || c == '[') {
                    lefts.push(c);
                } else if (!lefts.empty()) {
                    Character peek = lefts.peek();
                    if (peek == match.get(c)) {   //                    if ((c == ')' && peek == '(') || (c == '}' && peek == '{') || (c == ']' && peek == '[')){
                        lefts.pop();
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }
            }

            return lefts.empty();
        }
    }
}
