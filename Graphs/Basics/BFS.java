package Graphs.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        
        boolean[] visited = new boolean[V];
        
        int node = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        
        while(!q.isEmpty()){
            node = q.poll();
            bfs.add(node);
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
        int v = 5;
        // Initialize an ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        // Add empty ArrayLists to each vertex
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (as per your example)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(2).add(4);
        System.out.println(bfsOfGraph(v,adj));
    }
}
