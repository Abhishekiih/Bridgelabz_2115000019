import java.util.Scanner;

public class TotalPriceCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the unit price
        System.out.print("Enter the unit price of the item (INR): ");
        double unitPrice = input.nextDouble();

        // Prompt the user to enter the quantity
        System.out.print("Enter the quantity to be bought: ");
        int quantity = input.nextInt();

        // Calculate the total price
        double totalPrice = unitPrice * quantity;

        // Display the result
        System.out.println("The total purchase price is INR "+totalPrice+" if the quantity is "+quantity+" and the unit price is INR "+unitPrice+".");

    }
}
