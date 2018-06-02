package datastructures.tasks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};

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

            int[] result = new int[stack.size()];

            for (int i = result.length - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
        }
    }
}
