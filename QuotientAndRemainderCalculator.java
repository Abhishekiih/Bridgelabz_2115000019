import java.util.Scanner;

public class QuotientAndRemainderCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the two numbers
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        // Ensure the divisor (number2) is not zero
        if (number2 != 0) {
            // Calculate the quotient and remainder
            int quotient = number1 / number2;
            int remainder = number1 % number2;

            // Display the results
            System.out.println("The Quotient is "+quotient+" and the Remainder is "+remainder+" of the two numbers "+number1+" and "+number2+".");
        } else {
            System.out.println("Division by zero is not allowed.");
        }

        
    }
}
