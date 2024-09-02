package DynamicProgramming;

public class ShortestCommonSupersequnce {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(); // Length of the first string
        int m = str2.length(); // Length of the second string
    
        // Ensure that str1 is the shorter string to optimize space usage
        if (n > m) {
            return shortestCommonSupersequence(str2, str1);
        }
    
        // Initialize two rows for DP calculation
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
    
        // Fill the DP rows
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Swap rows: prev becomes curr, and curr becomes the new row
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
    
        // Backtrack to construct the SCS string
        StringBuilder s = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                s.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (prev[j] > curr[j - 1]) {
                s.append(str1.charAt(i - 1));
                i--;
            } else {
                s.append(str2.charAt(j - 1));
                j--;
            }
        }
    
        // Append any remaining characters
        while (i > 0) {
            s.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            s.append(str2.charAt(j - 1));
            j--;
        }
    
        // Return the reversed SCS
        return s.reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        // Expected output: "cabac" or "cabac"
        String result = shortestCommonSupersequence(str1, str2);
        System.out.println("Shortest Common Supersequence: " + result);
        System.out.println("hey");
    }
}
