import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            System.out.println("Multiples of " + number + " below 100 are:");

            // Find and print multiples below 100
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i); // i is a multiple of number
                }
            }
        }

    }
}
