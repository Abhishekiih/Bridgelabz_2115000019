import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input values for a, b, and c
        System.out.print("Enter value for a: ");
        int a = scanner.nextInt();
        System.out.print("Enter value for b: ");
        int b = scanner.nextInt();
        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();

        // Compute the integer operations
        int result1 = a + b * c;    // Multiplication (*) takes precedence over addition (+)
        int result2 = a * b + c;    // Multiplication (*) takes precedence over addition (+)
        int result3 = c + a / b;    // Division (/) takes precedence over addition (+)
        int result4 = a % b + c;    // Modulus (%) takes precedence over addition (+)

        // Print the results
        System.out.println("The results of Int Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        
    }
}
