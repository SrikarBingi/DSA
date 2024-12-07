package Strings;

public class CyclicRotation {
    public static int canBeCyclicallyConverted(String P, String Q) {
        int n = P.length();
        
        // Brute-force: try all rotations of P
        for (int i = 0; i < n; i++) {
            // Check if current rotation of P equals Q
            if (P.equals(Q)) {
                return 1;
            }
            // Perform one cyclic rotation to the right
            P = rotateRight(P);
        }
        
        // If no match found, return 0
        return 0;
    }
    
    // Helper method to perform one cyclic rotation to the right
    private static String rotateRight(String str) {
        int n = str.length();
        return str.charAt(n - 1) + str.substring(0, n - 1);
    }
    
    public static void main(String[] args) {
        
        
        // Test cases
        System.out.println(canBeCyclicallyConverted("pqrst", "tpqrs")); // Output: 1
        System.out.println(canBeCyclicallyConverted("abcde", "abced")); // Output: 0
    }
}
