public class RemoveCharacter {
    public static String removeCharacter(String str, char ch) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        String output = removeCharacter(input, charToRemove);
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + output);
    }
}
