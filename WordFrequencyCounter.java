import java.io.*;
import java.util.*;

class WordFrequencyCounter {
    public static void main(String[] args) {
        String filename = "input.txt"; // Replace with your file name
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", ""); // Remove punctuation
                String[] words = line.split("\\s+"); // Split by spaces

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Word Frequency: " + wordCount);
    }
}
