package datastructures.tasks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
//        int[] asteroids = {10, 2, -5};
//        int[] asteroids = {5, 10, -5};
        int[] asteroids = {8, -8};
//        int[] asteroids = {-2, -1, 1, 2};
//        int[] asteroids = {1,1,-2,-2};

        System.out.println(Arrays.toString(Solution.asteroidCollision(asteroids)));
    }

    static class Solution {
        public static int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int asteroid : asteroids) {
              stack.push(asteroid);
              if (asteroid < 0){
                  while (stack.size() > 1) {
                      int right = stack.pop(); //goes to the left
                      int left = stack.pop(); //goes to the right

                      if (right < 0 && left > 0) {
                          if (right * -1 > left) {
                              stack.push(right);
                          } else if (right * -1 < left) {
                              stack.push(left);
                          }
                      } else {
                          stack.push(left);
                          stack.push(right);
                          break;
                      }
                  }
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
