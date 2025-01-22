import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input the first number
        System.out.print("Enter the first number (number1): ");
        int number1 = scanner.nextInt();

        // Prompt the user to input the second number
        System.out.print("Enter the second number (number2): ");
        int number2 = scanner.nextInt();

        // Display the original numbers
        System.out.println("Before swapping: number1 = " + number1 + ", number2 = " + number2);

        // Swap the numbers
        int temp = number1;
        number1 = number2;
        number2 = temp;

        // Display the swapped numbers
        System.out.println("After swapping: number1 = " + number1 + ", number2 = " + number2);

        
    }
}
