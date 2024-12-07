package Graphs.TopoSort;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule1 {
    // DFS function to detect cycles
    public static boolean dfs(int node, boolean[] visited, boolean[] ancestor, List<List<Integer>> graph) {
        visited[node] = true;
        ancestor[node] = true;
        
        // Check all adjacent vertices
        for (int n : graph.get(node)) {
            if (!visited[n] && dfs(n, visited, ancestor, graph)) {
                return true;
            } else if (ancestor[n]) {
                return true;  // Cycle detected
            }
        }

        ancestor[node] = false;
        return false;
    }

    // Function to check if all courses can be finished
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] ancestor = new boolean[numCourses];

        // Initialize the graph (adjacency list)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph based on prerequisites
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(i, visited, ancestor, graph)) {
                return false;  // Cycle detected, cannot finish all courses
            }
        }
        
        return true;  // No cycle detected, all courses can be finished
    }

    // Test case to verify the implementation
    public static void main(String[] args) {
        
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};
        
        if (canFinish(numCourses, prerequisites)) {
            System.out.println("All courses can be finished.");
        } else {
            System.out.println("It's not possible to finish all courses.");
        }
    }
}
