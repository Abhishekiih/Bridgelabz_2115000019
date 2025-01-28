import java.util.Arrays;

public class NumberChecker2 {

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

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        int[] digits = storeDigits(number);
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int number) {
        int[] digits = storeDigits(number);
        int[][] frequency = new int[10][2];

        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;  // Digit
        }

        for (int digit : digits) {
            frequency[digit][1]++;  // Increment frequency
        }

        return frequency;
    }

    public static void main(String[] args) {
        int number = 1729;

        System.out.println("Number: " + number);

        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        int[] digits = storeDigits(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        int sum = sumOfDigits(digits);
        System.out.println("Sum of digits: " + sum);

        int sumOfSquares = sumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits: " + sumOfSquares);

        boolean isHarshad = isHarshadNumber(number);
        System.out.println("Is Harshad Number? " + isHarshad);

        int[][] frequency = digitFrequency(number);
        System.out.println("Digit Frequency:");
        for (int[] freq : frequency) {
            if (freq[1] > 0) {
                System.out.println("Digit: " + freq[0] + ", Frequency: " + freq[1]);
            }
        }
    }
}
