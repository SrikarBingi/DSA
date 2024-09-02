package Matrix;

class Pair {
    int row;
    int col;
    
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class BinarySearchMatrix {
    
    public static Pair searchMatrix(int[][] matrix, int x) {
        int n = matrix.length;    // Number of rows in the matrix
        int m = matrix[0].length; // Number of columns in the matrix
        
        int start = 0;
        int end = n * m - 1; // Total number of elements - 1 (last index)

        // Binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // Convert mid index to row and column indices
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == x) {
                return new Pair(row, col); // Element found, return its position
            } else if (matrix[row][col] > x) {
                end = mid - 1; // Search in the left half
            } else {
                start = mid + 1; // Search in the right half
            }
        }
        
        // Element not found, return (-1, -1)
        return new Pair(-1, -1);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int x = 3;

        Pair result = searchMatrix(matrix, x);
        System.out.println("Element found at: (" + result.row + ", " + result.col + ")");
    }
}
