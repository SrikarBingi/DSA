package Strings;

// import java.util.HashMap;
// import java.util.Map;

public class InterLeave {
    // public static boolean isInterleave(String a, String b, String c) {
    //     return isInterleaveHelper(a, b, c, 0, 0, 0);
    // }

    // private static boolean isInterleaveHelper(String a, String b, String c, int i, int j, int k) {
    //     // If all characters from c are used
    //     if (k == c.length()) {
    //         return i == a.length() && j == b.length();
    //     }

    //     // Check if the current character of a matches and we can proceed
    //     boolean matchA = i < a.length() && a.charAt(i) == c.charAt(k) && isInterleaveHelper(a, b, c, i + 1, j, k + 1);

    //     // Check if the current character of b matches and we can proceed
    //     boolean matchB = j < b.length() && b.charAt(j) == c.charAt(k) && isInterleaveHelper(a, b, c, i, j + 1, k + 1);

    //     return matchA || matchB;
    // }

    //Memoization

    // public static boolean isInterleave(String a, String b, String c) {
    //     // Memoization table
    //     Map<String, Boolean> memo = new HashMap<>();
    //     return isInterleaveHelper(a, b, c, 0, 0, 0, memo);
    // }

    // private static boolean isInterleaveHelper(String a, String b, String c, int i, int j, int k, Map<String, Boolean> memo) {
    //     // If all characters from c are used
    //     if (k == c.length()) {
    //         return i == a.length() && j == b.length();
    //     }

    //     // Create a unique key for the current state
    //     String key = i + "," + j + "," + k;
    //     if (memo.containsKey(key)) {
    //         return memo.get(key);
    //     }

    //     // Check if the current character of a matches and we can proceed
    //     boolean matchA = i < a.length() && a.charAt(i) == c.charAt(k) && isInterleaveHelper(a, b, c, i + 1, j, k + 1, memo);

    //     // Check if the current character of b matches and we can proceed
    //     boolean matchB = j < b.length() && b.charAt(j) == c.charAt(k) && isInterleaveHelper(a, b, c, i, j + 1, k + 1, memo);

    //     // Store the result in the memoization table and return it
    //     boolean result = matchA || matchB;
    //     memo.put(key, result);
    //     return result;
    // }

    // Tabulation

    public static boolean isInterleave(String a, String b, String c) {
        int n = a.length();
        int m = b.length();
        int len = c.length();

        // If length of c is not equal to the sum of lengths of a and b, return false
        if (len != n + m) {
            return false;
        }

        // DP table to store results of subproblems
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Initialize the DP table
        dp[0][0] = true;

        // Fill the first column
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && a.charAt(i - 1) == c.charAt(i + 0 - 1);
        }

        // Fill the first row
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] && b.charAt(j - 1) == c.charAt(0 + j - 1);
        }

        // Fill the rest of the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i - 1][j] && a.charAt(i - 1) == c.charAt(i + j - 1)) || 
                           (dp[i][j - 1] && b.charAt(j - 1) == c.charAt(i + j - 1));
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String a = "aabcc";
        String b = "dbbca";
        String c = "aadbbcbcac";

        boolean result = isInterleave(a, b, c);
        System.out.println(result);  // Output: true
    }
}
