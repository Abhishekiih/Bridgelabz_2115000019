import java.util.Scanner;

public class YoungestAndTallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to store age and height of the 3 friends
        int[] age = new int[3];
        double[] height = new double[3];
        
        // Input for age and height of 3 friends
        System.out.println("Enter details for the 3 friends:");

        // Taking input for age and height
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of friend " + (i + 1) + ": ");
            age[i] = scanner.nextInt();
            System.out.print("Enter height of friend " + (i + 1) + " (in meters): ");
            height[i] = scanner.nextDouble();
        }

        // Finding the youngest friend
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }
        }

        // Finding the tallest friend
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Displaying the youngest and tallest friends
        String[] names = {"Amar", "Akbar", "Anthony"};
        System.out.println("\nThe youngest friend is: " + names[youngestIndex] + " (Age: " + age[youngestIndex] + ")");
        System.out.println("The tallest friend is: " + names[tallestIndex] + " (Height: " + height[tallestIndex] + " meters)");
    }
}
