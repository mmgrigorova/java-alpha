package datastructures.tasks;

/**
 * Flood Fill
 * https://leetcode.com/problems/flood-fill/description/
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] image = {{0,0,0}, {0, 1, 1}};

        Solution.floodFill(image, 1, 1, 2);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.printf("%d ", image[i][j]);
            }
            System.out.println();
        }
    }

    static class Solution {

        public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int originalColor = image[sr][sc];

            if (originalColor == newColor){
                return image;
            }

            image[sr][sc] = newColor;
            int[] dRows = {-1, 0, +1, 0};
            int[] dCows = {0, +1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nextRow = sr + dRows[i];
                int nextCol = sc + dCows[i];

                if(hasAvailableUnvisitedNeighbours(nextRow, nextCol, image) && image[nextRow][nextCol] == originalColor){
                    floodFill(image, nextRow, nextCol, newColor);
                }
            }
            return image;
        }

        private static boolean hasAvailableUnvisitedNeighbours(int row, int col, int visited[][]) {
            return row < visited.length && col < visited[0].length
                    && row >= 0 && col >= 0;
//                    && !visited[row][col];
        }
    }
}
