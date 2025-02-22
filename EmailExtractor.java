import java.util.regex.*;
import java.util.Scanner;

public class EmailExtractor {
    public static void extractEmails(String text) {
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"; // Email pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each found email
            found = true;
        }

        if (!found) {
            System.out.println("❌ No email addresses found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();
        extractEmails(text);
        scanner.close();
    }
}
