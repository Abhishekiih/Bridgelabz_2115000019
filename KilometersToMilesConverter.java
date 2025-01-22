import java.util.Scanner;

public class KilometersToMilesConverter {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter distance in kilometers
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble(); // Read user input

        // Conversion factor from kilometers to miles
        double conversionFactor = 1.6;

        // Calculate the distance in miles
        double miles = km / conversionFactor;

        // Display the result
        System.out.println("The total miles is " + miles + " mile for the given " + km + "km");


    }
}
