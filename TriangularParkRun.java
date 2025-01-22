import java.util.Scanner;

public class TriangularParkRun {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Take user input for the three sides of the triangular park
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        // Calculate the perimeter of the triangular park
        double perimeter = side1 + side2 + side3;

        // Convert 5 km to meters
        double distanceToRun = 5000.0;

        // Calculate the number of rounds needed
        double rounds = distanceToRun / perimeter;

        // Print the result
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km.%n", rounds);

        
    }
}
