import java.util.Arrays;

public class NumberChecker3 {

    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] storeDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean isPalindrome(int number) {
        int[] digits = storeDigits(number);
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 1221;

        System.out.println("Number: " + number);

        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        int[] digits = storeDigits(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        int[] reversedDigits = reverseArray(digits);
        System.out.println("Reversed digits array: " + Arrays.toString(reversedDigits));

        boolean isEqual = compareArrays(digits, reversedDigits);
        System.out.println("Are original and reversed arrays equal? " + isEqual);

        boolean isPalindromeNumber = isPalindrome(number);
        System.out.println("Is Palindrome? " + isPalindromeNumber);

        boolean isDuck = isDuckNumber(number);
        System.out.println("Is Duck Number? " + isDuck);
    }
}
