package Graphs.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        
        
        int[] indegree = new int[V];
        
        for(int i=0;i<V;i++){
            for(int n : adj.get(i)){
                indegree[n]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int[] res = new int[V];
        int r = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            res[r++] = node;
            
            for(int n : adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0){
                    q.add(n);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        int[] topoOrder = topoSort(V, adj);
        
        System.out.println("Topological Sort:");
        for (int i : topoOrder) {
            System.out.print(i + " ");
        }
    }
}
