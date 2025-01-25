import java.util.Scanner;

public class BMIStatus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numberOfPersons = scanner.nextInt();

        double[] weight = new double[numberOfPersons];
        double[] height = new double[numberOfPersons];
        double[] bmi = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");

            System.out.print("Enter weight (in kg): ");
            weight[i] = scanner.nextDouble();

            System.out.print("Enter height (in meters): ");
            height[i] = scanner.nextDouble();

            // Calculate BMI
            bmi[i] = weight[i] / (height[i] * height[i]);

            // Determine weight status
            if (bmi[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi[i] >= 25 && bmi[i] <= 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        System.out.println("\nBMI Details:");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-15s%-15s\n", "Person", "Weight", "Height", "BMI", "Weight Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%-10d%-10.2f%-10.2f%-15.2f%-15s\n", i + 1, weight[i], height[i], bmi[i], weightStatus[i]);
        }
    }
}
