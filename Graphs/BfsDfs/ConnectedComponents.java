package Graphs.BfsDfs;

import java.util.ArrayList;

public class ConnectedComponents {
    // DFS function to traverse the graph from a given node
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, boolean[] visited) {
        // Mark the current node as visited
        visited[node] = true;
        
        // Traverse all the neighbors of the current node
        for (int neighbour : adjLs.get(node)) {
            // If the neighbor hasn't been visited, perform DFS on it
            if (!visited[neighbour]) {
                dfs(neighbour, adjLs, visited);
            }
        }
    }

    // Function to find the number of connected components (or circles) in the graph
    public static int findCircleNum(int[][] isConnected) {
        int v = isConnected.length; // Number of vertices (nodes)
        boolean[] visited = new boolean[v]; // Array to track visited nodes
        
        // Initialize the adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>(); 
        for (int i = 0; i < v; i++) {
            adjLs.add(new ArrayList<>()); 
        }
        
        // Convert the adjacency matrix to an adjacency list
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                // Only consider an edge if there is a connection and it's not a self-loop
                if (isConnected[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j); // Add edge from node i to node j
                    adjLs.get(j).add(i); // Add edge from node j to node i (since the graph is undirected)
                }
            }
        }
        
        int count = 0; // Variable to count the number of connected components
        for (int i = 0; i < v; i++) {
            // If the node hasn't been visited, it means we have found a new component
            if (!visited[i]) {
                dfs(i, adjLs, visited); // Perform DFS to visit all nodes in this component
                count++; // Increment the component count
            }
        }
        
        return count; // Return the total number of connected components
    }
    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));
    }
}


