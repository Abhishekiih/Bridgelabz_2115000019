import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateIPAddress {
    public static boolean isValidIPv4(String ip) {
        // Regular expression for a valid IPv4 address
        String ipv4Regex = 
            "^(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +  // First part (0-255)
            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +  // Second part (0-255)
            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +  // Third part (0-255)
            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";    // Fourth part (0-255)

        return Pattern.matches(ipv4Regex, ip); // Check if the IP matches the pattern
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an IP address:");
        String ip = scanner.nextLine();

        if (isValidIPv4(ip)) {
            System.out.println("✅ Valid IPv4 Address.");
        } else {
            System.out.println("❌ Invalid IPv4 Address.");
        }

        scanner.close();
    }
}
