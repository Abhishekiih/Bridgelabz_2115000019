import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter height in centimeters
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();

        // Conversion factors
        double cmToInches = 2.54; // 1 inch = 2.54 cm
        double inchesToFeet = 12; // 1 foot = 12 inches

        // Convert height to inches
        double totalInches = heightCm / cmToInches;

        // Convert inches to feet and remaining inches
        int feet = (int) (totalInches / inchesToFeet);
        double inches = totalInches % inchesToFeet;

        // Display the results
        System.out.println("Your height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inches);

        
    }
}
