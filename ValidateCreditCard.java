import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateCreditCard {
    public static boolean isValidCreditCard(String cardNumber) {
        // Regular expressions for Visa and MasterCard
        String visaRegex = "^4[0-9]{15}$";  // Visa: Starts with 4, exactly 16 digits
        String masterCardRegex = "^5[1-5][0-9]{14}$";  // MasterCard: Starts with 5 (51-55), exactly 16 digits

        return Pattern.matches(visaRegex, cardNumber) || Pattern.matches(masterCardRegex, cardNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a credit card number:");
        String cardNumber = scanner.nextLine();

        if (isValidCreditCard(cardNumber)) {
            System.out.println("✅ Valid Credit Card Number.");
        } else {
            System.out.println("❌ Invalid Credit Card Number.");
        }

        scanner.close();
    }
}
