import java.util.Scanner;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the base and height in inches
        System.out.print("Enter the base of the triangle in inches: ");
        double baseInches = input.nextDouble();

        System.out.print("Enter the height of the triangle in inches: ");
        double heightInches = input.nextDouble();

        // Calculate the area in square inches
        double areaInInches = 0.5 * baseInches * heightInches;

        // Conversion factor from square inches to square centimeters
        double conversionFactor = 6.4516; // 1 square inch = 6.4516 square centimeters
        double areaInCm = areaInInches * conversionFactor;

        // Display the results
        System.out.println("The area of the triangle is " +areaInInches+"  square inches and "+areaInCm+" square centimeters.");

        
    }
}
