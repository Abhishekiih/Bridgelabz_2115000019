import java.util.regex.*;
import java.util.Scanner;

public class LinkExtractor {
    public static void extractLinks(String text) {
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\S*"; // Regex for URLs
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each found URL
            found = true;
        }

        if (!found) {
            System.out.println("❌ No links found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text containing URLs:");
        String text = scanner.nextLine();
        extractLinks(text);
        scanner.close();
    }
}
