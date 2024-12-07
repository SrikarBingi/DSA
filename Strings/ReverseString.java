package Strings;

public class ReverseString {
    public static String stringReverse(char[] s) {
        int i = 0;
        int j = s.length - 1;
        
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        
        // Convert the char array back to a string and return it
        return new String(s);
    }

    public static void main(String[] args) {
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        String reversedString = stringReverse(input);
        System.out.println(reversedString); // Output should be "olleh"
    }
}
