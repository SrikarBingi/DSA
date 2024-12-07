package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateCharacters {
    public static List<Pair> findDuplicateCharacters(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Step 1: Count the frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Collect characters with frequency greater than 1
        List<Pair> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }

        return result;
    }

    // Pair class to store character and its frequency
    public static class Pair {
        char character;
        int frequency;

        public Pair(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "(" + character + ", " + frequency + ")";
        }
    }

    public static void main(String[] args) {
        String S = "APPLE";
        List<Pair> duplicates = findDuplicateCharacters(S);

        // Print the result
        for (Pair p : duplicates) {
            System.out.println(p);
        }
    }
}
