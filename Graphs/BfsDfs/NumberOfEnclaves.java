package Graphs.BfsDfs;

import java.util.LinkedList;
import java.util.Queue;

  // Class to represent a grid cell with its row and column indices
class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class NumberOfEnclaves {
  
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;       // Number of rows
        int m = grid[0].length;    // Number of columns

        // Create a visited array to keep track of visited cells
        int[][] vis = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        // Add all land cells on the boundaries to the queue and mark them as visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) { // Boundary check
                    if (grid[i][j] == 1) { // If it's land
                        q.add(new Node(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        // Direction vectors for moving up, down, left, and right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // BFS to mark all cells connected to the boundary land cells
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;

            q.poll();
            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                // Check if the new position is within bounds, is land, and hasn't been visited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol));
                }
            }
        }

        // Count the number of land cells that are not visited (enclaved)
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int grid[][] = {
        {0, 0, 0, 0},
        {1, 0, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0}};

        int ans = numEnclaves(grid);
        System.out.println(ans);
    }
}
