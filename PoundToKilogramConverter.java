import java.util.Scanner;

public class PoundToKilogramConverter {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Get the weight in pounds from the user
        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = scanner.nextDouble();

        // Convert weight to kilograms
        double weightInKilograms = weightInPounds * 2.2;

        // Print the result
        System.out.println("The weight of the person in pounds is " + weightInPounds + " and in kg is " + weightInKilograms);

        
    }
}
