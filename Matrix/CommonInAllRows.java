package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonInAllRows {
    public static List<Integer> findCommonElements(List<List<Integer>> mat) {
        int n = mat.size();           // Number of rows
        int m = mat.get(0).size();    // Number of columns

        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the matrix row by row
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>(); // To avoid counting duplicates in the same row
            for (int j = 0; j < m; j++) {
                int element = mat.get(i).get(j);
                
                // Only process the element if it hasn't been seen in the current row
                if (!rowSet.contains(element)) {
                    rowSet.add(element); // Mark as seen in the current row
                    
                    // Update count in the map
                    if (!map.containsKey(element)) {
                        map.put(element, 1);
                    } else {
                        map.put(element, map.get(element) + 1);
                    }
                }
            }
        }

        // Collect elements which are present in every row
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> mat = new ArrayList<>();
        mat.add(Arrays.asList(2, 3, 4, 7));
        mat.add(Arrays.asList(0, 2, 3, 5));
        mat.add(Arrays.asList(2, 3, 8, 9));

        List<Integer> commonElements = findCommonElements(mat);
        System.out.println(commonElements); // Output should be [3]
    }
}
