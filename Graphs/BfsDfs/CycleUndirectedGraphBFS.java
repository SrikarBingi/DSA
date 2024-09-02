package Graphs.BfsDfs;

import java.util.*;

// Class to represent a node and its parent in the BFS queue
class Node {
    int first;  // The current node
    int second; // The parent of the current node

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CycleUndirectedGraphBFS {

    // Function to check for a cycle in an undirected graph using BFS
    public static boolean checkForCycleBFS(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        // Queue to store the nodes for BFS, along with their parent nodes
        Queue<Node> q = new LinkedList<>();
        
        // Start with the initial node and assume it has no parent (-1)
        q.add(new Node(node, -1));
        
        // Mark the starting node as visited
        visited[node] = true;
        
        // BFS loop
        while (!q.isEmpty()) {
            node = q.peek().first;      // Current node
            int par = q.peek().second;  // Parent of the current node
            q.poll();                   // Remove the node from the queue

            // Iterate through all neighbors of the current node
            for (int neighbour : adj.get(node)) {
                // If the neighbor hasn't been visited, add it to the queue with the current node as its parent
                if (!visited[neighbour]) {
                    q.add(new Node(neighbour, node));
                    visited[neighbour] = true;
                } 
                // If the neighbor has been visited and is not the parent, a cycle is detected
                else if (par != neighbour) {
                    return true;
                }
            }
        }
        // If no cycle is found, return false
        return false;
    }

    // Function to check if the undirected graph contains a cycle
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to keep track of visited nodes
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false); // Initialize all nodes as unvisited
        
        // Check for cycles in each connected component of the graph
        for (int i = 0; i < V; i++) {
            if (!vis[i]) { // If the node hasn't been visited
                if (checkForCycleBFS(adj, i, vis)) { // Check for a cycle using BFS
                    return true; // If a cycle is found, return true
                }
            }
        }
        // If no cycles are found in any component, return false
        return false;
    }

    public static void main(String[] args) {
        // Create an adjacency list for the graph with 4 nodes (0 to 3)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList< > ());
        }
        
        // Add edges to the graph (undirected)
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        // Check if the graph contains a cycle
        boolean ans = isCycle(4, adj);
        System.out.println(ans);
    }
}
