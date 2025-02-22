import java.util.regex.*;
import java.util.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regular expression to match words
        String regex = "\\b(\\w+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Store words in a set to detect duplicates
        Set<String> seenWords = new HashSet<>();
        Set<String> repeatedWords = new LinkedHashSet<>(); // Maintain insertion order

        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case insensitivity
            if (!seenWords.add(word)) {
                repeatedWords.add(word);
            }
        }

        // Print the output
        System.out.println("Repeating Words: " + String.join(", ", repeatedWords));
    }
}
