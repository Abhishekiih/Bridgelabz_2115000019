import java.util.Scanner;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$"; // Pattern: Starts with a letter, 5-15 chars, only letters/numbers/_.
        return username.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("✅ " + username + " → Valid");
        } else {
            System.out.println("❌ " + username + " → Invalid");
        }
        scanner.close();
    }
}
