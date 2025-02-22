import java.util.Scanner;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        String regex = "^#([A-Fa-f0-9]{6})$"; // # followed by exactly 6 hex digits
        return color.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hex color code: ");
        String color = scanner.nextLine();

        if (isValidHexColor(color)) {
            System.out.println("✅ " + color + " → Valid");
        } else {
            System.out.println("❌ " + color + " → Invalid");
        }
        scanner.close();
    }
}
