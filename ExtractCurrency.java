import java.util.regex.*;
import java.util.*;

public class ExtractCurrency {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regular expression to match currency values (e.g., "$45.99", "10.50")
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Extracted currency values
        List<String> extractedValues = new ArrayList<>();
        while (matcher.find()) {
            extractedValues.add(matcher.group());
        }

        // Print the output
        System.out.println("Extracted Currency Values: " + String.join(", ", extractedValues));
    }
}
