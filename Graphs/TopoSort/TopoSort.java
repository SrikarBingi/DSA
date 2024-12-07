package Graphs.TopoSort;

import java.util.ArrayList;
import java.util.Stack;

public class TopoSort {
    // DFS function that explores the graph recursively
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        // Mark the current node as visited
        visited[node] = true;
        
        // Explore all the adjacent nodes of the current node
        for (int neighbour : adj.get(node)) {
            // If the adjacent node is not visited, recursively visit it
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, st);
            }
        }
        // After all adjacent nodes are visited, push the current node to the stack
        st.push(node);
    }

    // Function to return the list containing vertices in Topological order
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // Initialize a visited array to keep track of visited nodes
        boolean[] visited = new boolean[V];
        // Stack to store the topological sort order
        Stack<Integer> st = new Stack<>();
        
        // Call the DFS function for each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }
        
        // Store the result from stack to an array in reverse order
        int[] res = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.pop();
        }
        
        return res;
    }

    // Test case to verify the implementation
    public static void main(String[] args) {
        // Number of vertices
        int V = 6;
        // Create an adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Define the directed edges of the graph
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        // Perform topological sort
        int[] topoOrder = topoSort(V, adj);
        
        // Print the topological order
        System.out.println("Topological Sort:");
        for (int i : topoOrder) {
            System.out.print(i + " ");
        }
    }
}
