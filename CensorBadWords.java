import java.util.Scanner;

public class CensorBadWords {
    public static String censorBadWords(String text) {
        // Define a list of bad words (you can add more)
        String[] badWords = {"damn", "stupid"};
        
        // Replace each bad word with ****
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        String censoredText = censorBadWords(text);
        System.out.println("Censored Text: " + censoredText);

        scanner.close();
    }
}
