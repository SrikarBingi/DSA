package Graphs.BfsDfs;
import java.util.*;
public class FloodFill {
    // Helper function to perform DFS for flood fill
    public static void dfs(int i, int j, int[][] image, int color, int oldColor) {
        // Base case: Check if the current pixel is out of bounds or not the target color
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) {
            return;
        }
        
        // Change the color of the current pixel
        image[i][j] = color;
        
        // Recursively call DFS for the neighboring pixels (up, down, left, right)
        dfs(i + 1, j, image, color, oldColor); // Move down
        dfs(i - 1, j, image, color, oldColor); // Move up
        dfs(i, j + 1, image, color, oldColor); // Move right
        dfs(i, j - 1, image, color, oldColor); // Move left
    }

    // Main function to perform the flood fill operation
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Get the color of the starting pixel
        int oldColor = image[sr][sc];
        
        // If the new color is the same as the old color, no need to proceed
        if (color == oldColor) {
            return image; // Return the original image as no change is needed
        }
        
        // Perform DFS starting from the given pixel (sr, sc)
        dfs(sr, sc, image, color, oldColor);
        
        // Return the modified image
        return image;
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] res = floodFill(image, sr, sc, color);
        System.out.println(Arrays.deepToString(res));
    }
}
