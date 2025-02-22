import java.util.regex.*;
import java.util.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // List of programming languages to extract
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "C++", "C#", "Go", "Ruby", "Swift", "Kotlin");

        // Regex pattern to match programming languages
        String regex = "\\b(" + String.join("|", languages) + ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Extracted languages
        List<String> extractedLanguages = new ArrayList<>();
        while (matcher.find()) {
            extractedLanguages.add(matcher.group());
        }

        // Print the output
        System.out.println("Extracted Languages: " + String.join(", ", extractedLanguages));
    }
}
