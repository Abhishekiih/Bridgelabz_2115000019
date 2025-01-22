public class EarthVolumeCalculator {
    public static void main(String[] args) {
        // Define the radius of Earth in kilometers
        double radiusKm = 6378;
        double kmToMilesConversion = 0.621371; // Conversion factor from kilometers to miles

        // Compute the volume of Earth in cubic kilometers
        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);

        // Compute the volume of Earth in cubic miles
        double radiusMiles = radiusKm * kmToMilesConversion;
        double volumeMiles3 = (4.0 / 3) * Math.PI * Math.pow(radiusMiles, 3);

        // Display the results
        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm3 + " and in cubic miles is " + volumeMiles3);
    }
}
