import java.util.Scanner;

public class DistanceAndLineEquation {

    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];

        double m = (y2 - y1) / (x2 - x1);

        double b = y1 - m * x1;

        result[0] = m; // Slope
        result[1] = b; // y-intercept

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input points from the user
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean distance between the points: %.2f\n", distance);

        double[] equation = findLineEquation(x1, y1, x2, y2);
        System.out.printf("Equation of the line: y = %.2fx + %.2f\n", equation[0], equation[1]);
    }
}
