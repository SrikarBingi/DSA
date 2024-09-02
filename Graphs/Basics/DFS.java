package Graphs.Basics;

import java.util.ArrayList;

public class DFS {
    // This method performs DFS from a given node
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsTraversal) {
        // Mark the current node as visited
        visited[node] = true;
        
        // Add the current node to the DFS traversal result list
        dfsTraversal.add(node);
        
        // Explore all the neighbors of the current node
        for (int neighbour : adj.get(node)) {
            // If the neighbor has not been visited, perform DFS on the neighbor
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, dfsTraversal);
            }
        }
    }

    // This method initiates the DFS traversal for the graph
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create a visited array to keep track of visited nodes
        boolean[] visited = new boolean[V];
        
        // List to store the result of the DFS traversal
        ArrayList<Integer> dfsTraversal = new ArrayList<>();
        
        // Perform DFS starting from the first node (node 0)
        dfs(0, adj, visited, dfsTraversal);
        
        // Return the list containing the DFS traversal order
        return dfsTraversal;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        
        // Create an object of GraphDFS and perform DFS traversal
        
        ArrayList<Integer> result = dfsOfGraph(V, adj);
        
        // Print the DFS traversal result
        System.out.println("DFS Traversal of the graph: " + result);
    }
}
