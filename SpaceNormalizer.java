import java.util.Scanner;

public class SpaceNormalizer {
    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " "); // Replace multiple spaces with a single space
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text with multiple spaces:");
        String text = scanner.nextLine();
        
        String result = replaceMultipleSpaces(text);
        System.out.println("Modified Text: " + result);
        
        scanner.close();
    }
}
