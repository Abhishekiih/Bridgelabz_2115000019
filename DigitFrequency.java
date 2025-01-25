import java.util.Scanner;

public class DigitFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        int[] frequency = new int[10];  // Array to store the frequency of each digit (0 to 9)

        while (number > 0) {
            int digit = (int) (number % 10);  // Get the last digit of the number
            frequency[digit]++;  // Increment the frequency of that digit
            number = number / 10;  // Remove the last digit
        }

        System.out.println("Frequency of each digit:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
    }
}
