import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String text = "My SSN is 123-45-6789 and my old SSN was 987-65-4321.";
        
        // Regular expression for SSN (Format: XXX-XX-XXXX)
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println("✅ \"" + matcher.group() + "\" is valid");
            found = true;
        }
        
        if (!found) {
            System.out.println("❌ No valid SSN found.");
        }
    }
}
