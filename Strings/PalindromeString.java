package Strings;

public class PalindromeString {
    public static boolean isPalindrome(String s) {
        // Step 1: Normalize the string
        StringBuilder normalizedStr = new StringBuilder();
        
        // Convert to lowercase and keep only alphanumeric characters using ASCII values
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                normalizedStr.append(Character.toLowerCase(c));
            }
        }
        
        // Step 2: Check if the normalized string is a palindrome
        int i = 0;
        int j = normalizedStr.length() - 1;
        
        while (i < j) {
            if (normalizedStr.charAt(i) != normalizedStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }

    public static void main(String[] args) {
        String S = "c1 O$d@eeD o1c";
        boolean result = isPalindrome(S);
        System.out.println(result); // Output should be true
    }
}
