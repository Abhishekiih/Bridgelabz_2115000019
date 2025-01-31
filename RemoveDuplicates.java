public class RemoveDuplicates {
    public static String removeDuplicateChars(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "programming";
        String output = removeDuplicateChars(input);
        System.out.println("Original String: " + input);
        System.out.println("String after removing duplicates: " + output);
    }
}
