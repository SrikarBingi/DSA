package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int rs = 0;               // Starting row index
        int re = matrix.length - 1; // Ending row index
        int cs = 0;               // Starting column index
        int ce = matrix[0].length - 1; // Ending column index

        while (rs <= re && cs <= ce) {
            // Traverse from left to right
            for (int i = cs; i <= ce; i++) {
                res.add(matrix[rs][i]);
            }
            rs++; // Move down to the next row

            // Traverse from top to bottom
            for (int i = rs; i <= re; i++) {
                res.add(matrix[i][ce]);
            }
            ce--; // Move left to the next column

            // Traverse from right to left, if there are remaining rows
            if (rs <= re) {
                for (int i = ce; i >= cs; i--) {
                    res.add(matrix[re][i]);
                }
                re--; // Move up to the previous row
            }

            // Traverse from bottom to top, if there are remaining columns
            if (cs <= ce) {
                for (int i = re; i >= rs; i--) {
                    res.add(matrix[i][cs]);
                }
                cs++; // Move right to the next column
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> result = spiralOrder(matrix);
        System.out.println(result); // Expected output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
