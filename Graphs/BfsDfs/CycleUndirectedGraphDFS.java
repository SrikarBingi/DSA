package Graphs.BfsDfs;

import java.util.ArrayList;

public class CycleUndirectedGraphDFS {

    // Helper function to perform DFS and check for a cycle
    public static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited
        visited[node] = true;

        // Traverse all the adjacent nodes
        for (int neighbour : adj.get(node)) {
            // If the adjacent node has not been visited, perform DFS on it
            if (!visited[neighbour]) {
                if (dfs(neighbour, node, visited, adj)) {
                    return true; // If a cycle is found, return true
                }
            }
            // If the adjacent node is visited and it's not the parent, a cycle is detected
            else if (neighbour != parent) {
                return true;
            }
        }
        // If no cycle is found, return false
        return false;
    }

    // Function to check if there is a cycle in an undirected graph
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to keep track of visited nodes
        boolean[] vis = new boolean[V];

        // Check for cycles in each connected component of the graph
        for (int i = 0; i < V; i++) {
            if (!vis[i]) { // If the node hasn't been visited
                if (dfs(i, -1, vis, adj)) {
                    return true; // If a cycle is found, return true
                }
            }
        }
        // If no cycles are found, return false
        return false;
    }

    public static void main(String[] args) {
        // Create an adjacency list for the graph with 4 nodes (0 to 3)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected)
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1); // Corrected the edge addition

        // Check if the graph contains a cycle
        boolean ans = isCycle(4, adj);
        System.out.println(ans);
    }
}