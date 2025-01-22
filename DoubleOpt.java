import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input values for a, b, and c
        System.out.print("Enter value for a (double): ");
        double a = scanner.nextDouble();
        System.out.print("Enter value for b (double): ");
        double b = scanner.nextDouble();
        System.out.print("Enter value for c (double): ");
        double c = scanner.nextDouble();

        // Compute the double operations
        double result1 = a + b * c;    // Multiplication (*) takes precedence over addition (+)
        double result2 = a * b + c;    // Multiplication (*) takes precedence over addition (+)
        double result3 = c + a / b;    // Division (/) takes precedence over addition (+)
        double result4 = a % b + c;    // Modulus (%) takes precedence over addition (+)

        // Print the results
        System.out.println("The results of Double Operations are:");
        System.out.printf("a + b * c = %.2f%n", result1);
        System.out.printf("a * b + c = %.2f%n", result2);
        System.out.printf("c + a / b = %.2f%n", result3);
        System.out.printf("a %% b + c = %.2f%n", result4); // %% is used to escape % in printf

        
    }
}
