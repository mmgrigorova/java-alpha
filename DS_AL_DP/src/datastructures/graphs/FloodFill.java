package datastructures.graphs;

import java.util.Stack;

public class FloodFill {
    public static void main(String[] args) {
       int[][] image = {{1,1,1},{1,1,0},{1,0,1}};

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.printf("%d ", image[i][j]);
            }
            System.out.println();
        }
    }

    static  class Solution {
        public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            boolean[][] visited = new boolean[image.length][image[0].length];

            int[] dRows = {-1, 0, +1, 0};
            int[] dCows = {0, +1, 0, -1};

            Stack<Integer> stack = new Stack<>();

            stack.push(image[sr][sc]);
            visited[sr][sc] = true;

            while(!stack.empty()){

                boolean hasNext = hasAvailableUnvisitedNeighbours(sr, sc, visited);
                {
                    int nRow, nCol = 0;
                }

            }


            return image;
        }

        private static boolean hasAvailableUnvisitedNeighbours(int row, int col, boolean visited[][]) {
            return row < visited.length && col < visited[0].length
                    && row >= 0 && col >= 0
                    && !visited[row][col];
        }
    }
}
