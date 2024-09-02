package Matrix;
import java.util.*;


public class SortedMatrixHeap {
    
    // Helper class to store matrix elements along with their row and column index
    static class MatrixElement {
        int value;
        int row;
        int col;

        MatrixElement(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static List<Integer> sortMatrix(int[][] mat) {
        int n = mat.length;
        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<MatrixElement> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

        // Initialize the min-heap with the first element of each row
        for (int i = 0; i < n; i++) {
            minHeap.add(new MatrixElement(mat[i][0], i, 0));
        }

        // Process the heap
        while (!minHeap.isEmpty()) {
            MatrixElement minElement = minHeap.poll();
            sortedList.add(minElement.value);

            // If there is a next element in the same row, add it to the heap
            if (minElement.col + 1 < n) {
                minHeap.add(new MatrixElement(mat[minElement.row][minElement.col + 1], minElement.row, minElement.col + 1));
            }
        }

        return sortedList;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 20, 35, 42},
            {27, 29, 37, 46},
            {32, 33, 38, 49}
        };

        List<Integer> sortedElements = sortMatrix(matrix);
        System.out.println(sortedElements); // Output: [10, 15, 20, 20, 27, 29, 30, 32, 33, 35, 37, 38, 40, 42, 46, 49]
    }
}

