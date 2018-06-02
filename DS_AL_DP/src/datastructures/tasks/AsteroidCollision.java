package datastructures.tasks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
//        int[] asteroids = {10, 2, -5};
//        int[] asteroids = {5, 10, -5};
//        int[] asteroids = {8, -8};
//        int[] asteroids = {-2, -1, 1, 2};
        int[] asteroids = {1,1,-2,-2};

        System.out.println(Arrays.toString(Solution.asteroidCollision(asteroids)));
    }

    static class Solution {
        public static int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int asteroid : asteroids) {
                if ((asteroid < 0) && (stack.empty() || stack.peek() < 0)) {
                    stack.push(asteroid);
                    continue;
                }
                if (!stack.empty()) {
                    if (asteroid < 0 && stack.peek() > 0) {
                        if (Math.abs(asteroid) > stack.peek()) {
                            stack.pop();
                            stack.push(asteroid);

                        } else if (Math.abs(asteroid) == stack.peek()) {
                            stack.pop();
                        }
                    } else {
                        stack.push(asteroid);
                    }
                } else {
                    stack.push(asteroid);
                }
            }

            while (stack.size() > 1) {
                int top = stack.pop();
                int second = stack.peek();

                if (top < 0 && second > 0) {
                    if (Math.abs(top) > stack.peek()) {
                        stack.pop();
                        stack.push(top);

                    } else if (Math.abs(top) == stack.peek()) {
                        stack.pop();
                    }
                } else {
                    stack.push(top);
                    break;
                }
            }

            int[] result = new int[stack.size()];

            for (int i = result.length - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
        }
    }
}
