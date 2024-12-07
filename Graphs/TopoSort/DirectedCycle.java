package Graphs.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedCycle {
    // DFS function to detect a cycle
    public static boolean dfs(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited and add to recursion stack
        visited[node] = true;
        recStack[node] = true;
        
        // Check all adjacent vertices
        for (int n : adj.get(node)) {
            // If the adjacent vertex is not visited, recurse on it
            if (!visited[n] && dfs(n, visited, recStack, adj)) {
                return true;
            }
            // If the adjacent vertex is in the recursion stack, a cycle is found
            else if (recStack[n]) {
                return true;
            }
        }
        
        // Remove the current node from the recursion stack
        recStack[node] = false;
        return false;
    }

    // Function to check if the graph contains a cycle
    public static boolean isCyclicDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        // Initialize visited and recursion stack arrays
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        // Perform DFS for each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, visited, recStack, adj)) {
                return true;  // Cycle found
            }
        }
        return false;  // No cycle found
    }

    // Function to detect cycle in a directed graph using Kahn's Algorithm
    public static boolean isCyclicBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        
        // Calculate in-degree for each vertex
        for (int i = 0; i < V; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }
        
        // Initialize a queue and enqueue all vertices with in-degree 0
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int count = 0;
        
        // Process the queue
        while (!q.isEmpty()) {
            int node = q.remove();
            count++;
            
            // Decrease in-degree of adjacent vertices
            for (int n : adj.get(node)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    q.add(n);
                }
            }
        }
        
        // If count of processed nodes is less than V, a cycle exists
        return count != V;
    }

    // Test case to verify the implementation
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        if (isCyclicDFS(V, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph doesn't contain a cycle");
        }
        if (isCyclicBFS(V, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph doesn't contain a cycle");
        }
    }
}
