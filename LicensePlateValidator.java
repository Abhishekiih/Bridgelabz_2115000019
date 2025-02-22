import java.util.Scanner;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$"; // Two uppercase letters + four digits
        return plate.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();

        if (isValidLicensePlate(plate)) {
            System.out.println("✅ " + plate + " -> Valid");
        } else {
            System.out.println("❌ " + plate + " → Invalid");
        }
        scanner.close();
    }
}
