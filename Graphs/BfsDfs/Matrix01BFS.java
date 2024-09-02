package Graphs.BfsDfs;
import java.util.*;

// Node class to store the coordinates of the cell and the number of steps taken from the nearest '0'
class Node {
    int first;  // Row index
    int second; // Column index
    int steps;  // Distance from the nearest '0'

    public Node(int first, int second, int steps) {
        this.first = first;
        this.second = second;
        this.steps = steps;
    }
}

public class Matrix01BFS {

    // Function to update the matrix with the distance of each cell from the nearest '0'
    public static int[][] updateMatrix(int[][] mat) {
        Queue<Node> q = new LinkedList<>();
        int n = mat.length;    // Number of rows in the matrix
        int m = mat[0].length; // Number of columns in the matrix
        int[][] vis = new int[n][m]; // Visited matrix to keep track of visited cells
        int[][] dis = new int[n][m]; // Distance matrix to store the result

        // Initialize the queue with all '0' cells and mark them as visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1; // Mark '0' cells as visited
                }
            }
        }

        // Directions array for moving up, down, left, and right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // BFS traversal
        while (!q.isEmpty()) {
            int row = q.peek().first;    // Current row
            int col = q.peek().second;   // Current column
            int steps = q.peek().steps;  // Steps from the nearest '0'

            dis[row][col] = steps;       // Update the distance for the current cell

            q.poll(); // Remove the current node from the queue

            // Explore the four possible directions
            for (int[] dir : directions) {
                int nrow = row + dir[0]; // New row index after moving
                int ncol = col + dir[1]; // New column index after moving

                // Check if the new cell is within bounds and not visited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1; // Mark the new cell as visited
                    q.add(new Node(nrow, ncol, steps + 1)); // Add the new cell to the queue with updated steps
                }
            }
        }
        return dis; // Return the updated distance matrix
    }

    public static void main(String[] args) {
        // Input grid
        int[][] grid = {
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
        };

        // Call the updateMatrix function and store the result
        int[][] ans = updateMatrix(grid);

        // Print the result matrix
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}