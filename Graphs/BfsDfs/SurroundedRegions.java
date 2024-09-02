package Graphs.BfsDfs;

public class SurroundedRegions {
    // Perform DFS to mark the connected 'O's from the boundary
    public static void dfs(int i, int j, int n, int m, char[][] board) {
        // Boundary check or if the cell is not 'O', return
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') {
            return;
        }
        // Mark the cell as 'S' to indicate it shouldn't be flipped
        board[i][j] = 'S';

        // Perform DFS in all four directions
        dfs(i + 1, j, n, m, board); // Down
        dfs(i - 1, j, n, m, board); // Up
        dfs(i, j + 1, n, m, board); // Right
        dfs(i, j - 1, n, m, board); // Left
    }

    // Main function to solve the surrounded regions problem
    public static void solve(char[][] board) {
        int n = board.length;      // Number of rows
        int m = board[0].length;   // Number of columns

        // Traverse the first and last columns
        for (int i = 0; i < n; i++) {
            // Check first column
            if (board[i][0] == 'O') {
                dfs(i, 0, n, m, board);
            }
            // Check last column
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, n, m, board);
            }
        }

        // Traverse the first and last rows
        for (int j = 0; j < m; j++) {
            // Check first row
            if (board[0][j] == 'O') {
                dfs(0, j, n, m, board);
            }
            // Check last row
            if (board[n - 1][j] == 'O') {
                dfs(n - 1, j, n, m, board);
            }
        }

        // Flip the surrounded 'O's to 'X' and revert 'S' back to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Surrounded 'O' -> 'X'
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                // Boundary-connected 'O' -> revert 'S' to 'O'
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // Test case to validate the solution
    public static void main(String[] args) {

        // Example test case
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        System.out.println("Original Board:");
        printBoard(board);

        solve(board);

        System.out.println("Board after solving:");
        printBoard(board);
    }

    // Helper method to print the board
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
