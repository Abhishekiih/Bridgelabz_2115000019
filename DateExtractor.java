import java.util.regex.*;
import java.util.Scanner;

public class DateExtractor {
    public static void extractDates(String text) {
        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})\\b"; // dd/mm/yyyy format
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group()); // Print each extracted date
            found = true;
        }

        if (!found) {
            System.out.println("❌ No valid dates found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text containing dates (dd/mm/yyyy format):");
        String text = scanner.nextLine();
        extractDates(text);
        scanner.close();
    }
}
