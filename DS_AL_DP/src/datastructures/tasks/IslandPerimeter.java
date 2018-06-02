package datastructures.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Island Perimeter
 * https://leetcode.com/problems/island-perimeter/description/
 */

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};

        int[][] grid = {{1},{0}};

        int result = Solution.islandPerimeter(grid);

        System.out.println(result);
    }


    public static class Solution {
        public static int islandPerimeter(int[][] grid) {
            int perimeter = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int cell = grid[i][j];
                    if (cell != 0) {
                        perimeter += cellPerimeter(i, j, grid);
                    }
                }
            }
            return perimeter;
        }

        static int cellPerimeter(int r, int c, int[][] grid) {
            int borderV = grid.length;
            int borderH = grid[0].length;
            int perimeter = 0;

            //top , right, bottom, left
            int[] dRows = {-1, 0, +1, 0};
            int[] dCows = {0, +1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int row = r + dRows[i];
                int col = c + dCows[i];

                if (row < 0 || row == borderV) {
                    perimeter += 1;
                }
                if (col < 0 || col == borderH) {
                    perimeter += 1;
                }
                if (row >= 0 && row < borderV
                        && col >= 0 && col < borderH
                        && grid[row][col] == 0){
                    perimeter += 1;
                }
            }

            return perimeter;
        }
    }
}
