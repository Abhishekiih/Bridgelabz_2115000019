public class KilometerToMiles {
    public static void main(String[] args) {
        // Define the distance in kilometers and the conversion factor
        double kilometers = 10.8;
        double conversionFactor = 1 / 1.6; // 1 km = 1/1.6 miles

        // Convert kilometers to miles
        double miles = kilometers * conversionFactor;

        // Print the result
        System.out.printf("The distance %.1f km in miles is %.2f%n", kilometers, miles);
    }
}
