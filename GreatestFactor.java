import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        if (number <= 1) {
            System.out.println("There are no factors other than the number itself for " + number + ".");
        } else {
            int greatestFactor = 1;

            // Loop to find the greatest factor
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }

            // Display the result
            System.out.println("The greatest factor of " + number + " (other than itself) is: " + greatestFactor);
        }

    }
}
