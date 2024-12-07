package Graphs.TopoSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {
    /**
     * DFS function to detect cycles and perform topological sorting.
     *
     * @param node     Current node being visited.
     * @param visited  Array to keep track of visited nodes.
     * @param ancestor Array to keep track of nodes in the current DFS path.
     * @param graph    Adjacency list representing the graph.
     * @param st       Stack to store the topological order.
     * @return true if a cycle is detected, false otherwise.
     */
    public static boolean dfs(int node, boolean[] visited, boolean[] ancestor, List<List<Integer>> graph, Stack<Integer> st) {
        // Mark the current node as visited and add it to the recursion stack
        visited[node] = true;
        ancestor[node] = true;

        // Explore all adjacent nodes
        for (int neighbor : graph.get(node)) {
            // If the neighbor is already in the recursion stack, a cycle is detected
            if (ancestor[neighbor]) {
                return true;
            }
            // If the neighbor hasn't been visited, recurse on it
            if (!visited[neighbor] && dfs(neighbor, visited, ancestor, graph, st)) {
                return true;
            }
        }

        // After visiting all descendants, push the current node to the stack
        st.push(node);
        // Remove the node from the recursion stack
        ancestor[node] = false;
        return false;
    }

    /**
     * Function to find a possible order of courses to finish all courses.
     *
     * @param numCourses    Total number of courses.
     * @param prerequisites 2D array where prerequisites[i] = [a, b] indicates that to take course a you must first take course b.
     * @return An array representing the course order. If it's impossible to finish all courses, return an empty array.
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Initialize the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph: for each prerequisite pair [a, b], add an edge from b to a
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
        }

        // Arrays to keep track of visited nodes and nodes in the current DFS path
        boolean[] visited = new boolean[numCourses];
        boolean[] ancestor = new boolean[numCourses];
        // Stack to store the topological order
        Stack<Integer> st = new Stack<>();

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                // If a cycle is detected during DFS, return an empty array
                if (dfs(i, visited, ancestor, graph, st)) {
                    return new int[0];
                }
            }
        }

        // If no cycle is detected, pop elements from the stack to get the course order
        int[] res = new int[numCourses];
        int index = 0;
        while (!st.isEmpty()) {
            res[index++] = st.pop();
        }

        return res;
    }

    /**
     * Main method to test the findOrder function.
     */
    public static void main(String[] args) {
        // Test Case 1: Possible to finish all courses
        int numCourses1 = 4;
        int[][] prerequisites1 = {
            {1, 0}, // To take course 1 you must first take course 0
            {2, 1}, // To take course 2 you must first take course 1
            {3, 2}  // To take course 3 you must first take course 2
        };

        int[] order1 = findOrder(numCourses1, prerequisites1);
        System.out.println("Test Case 1: " + (order1.length > 0 ? "Possible" : "Impossible"));
        if (order1.length > 0) {
            System.out.print("Course Order: ");
            for (int course : order1) {
                System.out.print(course + " ");
            }
            System.out.println();
        }

        // Test Case 2: Impossible to finish all courses (cycle exists)
        int numCourses2 = 4;
        int[][] prerequisites2 = {
            {1, 0},
            {2, 1},
            {3, 2},
            {1, 3}  // Introduces a cycle: 1 -> 3 -> 2 -> 1
        };

        int[] order2 = findOrder(numCourses2, prerequisites2);
        System.out.println("\nTest Case 2: " + (order2.length > 0 ? "Possible" : "Impossible"));
        if (order2.length > 0) {
            System.out.print("Course Order: ");
            for (int course : order2) {
                System.out.print(course + " ");
            }
            System.out.println();
        }
    }
}
