public class ToggleCase {
    public static String toggleCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } else {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "Hello World!";
        String output = toggleCase(input);
        System.out.println("Original String: " + input);
        System.out.println("Toggled String: " + output);
    }
}
