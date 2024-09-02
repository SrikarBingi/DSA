package Graphs.Basics;

import java.util.ArrayList;
import java.util.List;

public class GraphsRepresentation {
    //Adjacency List
    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        int v=5;
        int[][] edges = {{0,1},{0,4},{4,1},{4,3},{1,3},{1,2},{3,2}};
        System.out.println(printGraph(v,edges));
    }
}
