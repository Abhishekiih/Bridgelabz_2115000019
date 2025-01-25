import java.util.Scanner;

public class BMIStatus2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numberOfPersons = scanner.nextInt();

        double[][] personData = new double[numberOfPersons][3];  // To store weight, height, and BMI
        String[] weightStatus = new String[numberOfPersons];  // To store the weight status

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");

            // Take input for weight and height
            double weight = -1, height = -1;
            while (weight <= 0) {
                System.out.print("Enter weight (in kg): ");
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be a positive value. Please enter again.");
                }
            }

            while (height <= 0) {
                System.out.print("Enter height (in meters): ");
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be a positive value. Please enter again.");
                }
            }

            // Store weight and height in the array
            personData[i][0] = weight;
            personData[i][1] = height;

            // Calculate BMI and store it
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            // Determine the weight status
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi <= 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        // Display the details for each person
        System.out.println("\nBMI Details:");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-15s%-15s\n", "Person", "Weight", "Height", "BMI", "Weight Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%-10d%-10.2f%-10.2f%-15.2f%-15s\n", i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
