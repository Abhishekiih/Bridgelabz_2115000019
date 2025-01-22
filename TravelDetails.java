import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        // Create a Scanner object to take user inputs
        Scanner scanner = new Scanner(System.in);

        // Take user input for personal and city details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your city of departure (fromCity): ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter your stopover city (viaCity): ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter your destination city (toCity): ");
        String toCity = scanner.nextLine();

        // Take user input for distances and time
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double fromToVia = scanner.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        double viaToFinalCity = scanner.nextDouble();

        System.out.print("Enter the total time taken for the journey (in hours): ");
        double timeTaken = scanner.nextDouble();

        // Calculate total distance and average speed
        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        // Print the results
        System.out.println("\n--- Travel Details ---");
        System.out.println("Name: " + name);
        System.out.println("Route: " + fromCity + " -> " + viaCity + " -> " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Average Speed: " + averageSpeed + " miles/hour");

        
    }
}
