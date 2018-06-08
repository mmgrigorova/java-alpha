package datastructures.tasks;

import java.util.Stack;

public class LargestRectangeIterative {
    public static void main(String[] args) {
//        int[] h = {2,1,5,6,2,3};
        int[] h = {2,1,2};

        int best = Solution.largestRectangleArea(h);
        System.out.println(best);
    }

    static class Solution {
        public static int largestRectangleArea(int[] h) {
            int bestArea = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < h.length; i++) {
                int next = h[i];
                int count = 0;
                while(!stack.empty() && next < stack.peek()){
                    int minInStack = Integer.MAX_VALUE;
                    int popped = stack.pop();
                    count += 1;
                    minInStack = Math.min(popped, minInStack);
                    int tempArea = calcArea(minInStack, count);
                    bestArea = Math.max(tempArea, bestArea);
                }
                stack.push(next);
            }


            int count = 0;
            while(!stack.empty()){
                int minInStack = Integer.MAX_VALUE;
                int popped = stack.pop();
                count += 1;
                minInStack = Math.min(popped, minInStack);
                int tempArea = calcArea(minInStack, count);
                bestArea = Math.max(tempArea, bestArea);
            }
            return bestArea;
        }

        private static int calcArea(int minInStack, int count) {
            return minInStack*count;
        }
    }
}
