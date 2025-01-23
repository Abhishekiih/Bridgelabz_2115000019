import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            System.out.println("Factors of " + number + " are:");

            // Find and print factors
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println(i); // i is a factor of number
                }
            }
        }

    }
}
