import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the distance in feet
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = input.nextDouble();

        // Conversion factors
        double feetToYards = 3; // 1 yard = 3 feet
        double yardsToMiles = 1760; // 1 mile = 1760 yards

        // Calculate the distance in yards and miles
        double distanceInYards = distanceInFeet / feetToYards;
        double distanceInMiles = distanceInYards / yardsToMiles;

        // Display the results
        System.out.println("The distance is "+distanceInYards+" yards and "+distanceInMiles+" miles for the given "+distanceInFeet+" feet.");

        
    }
}
