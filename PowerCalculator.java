import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the base number and the power
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();

        int result = 1;

        // Calculate the power using a loop
        for (int i = 1; i <= power; i++) {
            result *= number; // Multiply result by the base number
        }

        // Display the result
        System.out.println(number + " raised to the power of " + power + " is: " + result);

    }
}
