package Graphs.BfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;       // Number of rows in the grid
        int m = grid[0].length;    // Number of columns in the grid

        Queue<int[]> q = new LinkedList<>();  // Queue to perform BFS

        int fresh = 0;  // Counter for fresh oranges

        // Traverse the grid to find all rotten oranges and count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {  // If the orange is rotten
                    q.add(new int[]{i, j});  // Add its position to the queue
                }
                if (grid[i][j] == 1) {  // If the orange is fresh
                    fresh++;  // Increment the fresh orange counter
                }
            }
        }

        // If there are no fresh oranges, return 0 as no time is needed
        if (fresh == 0) {
            return 0;
        }

        int time = 0;  // Variable to keep track of time (minutes)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // Directions array for moving up, down, left, and right
        int count = 0;  // Counter for the number of fresh oranges that have turned rotten

        // BFS to spread rot to adjacent fresh oranges
        while (!q.isEmpty()) {
            int size = q.size();  // Get the current size of the queue
            boolean isRotten = false;  // Flag to check if any fresh orange turns rotten in this round
            
            for (int i = 0; i < size; i++) {
                int[] a = q.poll();  // Get the current rotten orange position from the queue
                
                // Explore all 4 possible directions
                for (int[] dir : directions) {
                    int newX = a[0] + dir[0];  // Calculate the new x-coordinate
                    int newY = a[1] + dir[1];  // Calculate the new y-coordinate
                    
                    // Check if the new position is within bounds and contains a fresh orange
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                        count++;  // Increment the count of rotten oranges
                        isRotten = true;  // Set the flag to true as we have found a fresh orange to rot
                        grid[newX][newY] = 2;  // Mark the orange as rotten
                        q.add(new int[]{newX, newY});  // Add the new rotten orange position to the queue
                    }
                }
            }
            
            // If any fresh orange was rotten in this iteration, increment the time
            if (isRotten) {
                time++;
            }
        }

        // If all fresh oranges have turned rotten, return the time taken, otherwise return -1
        return fresh == count ? time : -1;
    }

    public static void main(String[] args) {
        RottenOranges ro = new RottenOranges();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println("Time to rot all oranges: " + ro.orangesRotting(grid));
    }
}
