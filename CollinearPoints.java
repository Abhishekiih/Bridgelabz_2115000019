import java.util.Scanner;

public class CollinearPoints {

    public static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = (double) (y2 - y1) / (x2 - x1);
        double slopeBC = (double) (y3 - y2) / (x3 - x2);
        double slopeAC = (double) (y3 - y1) / (x3 - x1);
        return (slopeAB == slopeBC && slopeBC == slopeAC);
    }

    public static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1: ");
        int x1 = scanner.nextInt();
        System.out.print("Enter y1: ");
        int y1 = scanner.nextInt();
        System.out.print("Enter x2: ");
        int x2 = scanner.nextInt();
        System.out.print("Enter y2: ");
        int y2 = scanner.nextInt();
        System.out.print("Enter x3: ");
        int x3 = scanner.nextInt();
        System.out.print("Enter y3: ");
        int y3 = scanner.nextInt();

        boolean collinearBySlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean collinearByArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);

        if (collinearBySlope && collinearByArea) {
            System.out.println("The points are collinear.");
        } else {
            System.out.println("The points are not collinear.");
        }

        System.out.println("Sample check (A(2, 4), B(4, 6), C(6, 8)):");
        boolean sampleCollinearBySlope = areCollinearBySlope(2, 4, 4, 6, 6, 8);
        boolean sampleCollinearByArea = areCollinearByArea(2, 4, 4, 6, 6, 8);
        
        if (sampleCollinearBySlope && sampleCollinearByArea) {
            System.out.println("The points A(2, 4), B(4, 6), C(6, 8) are collinear.");
        } else {
            System.out.println("The points A(2, 4), B(4, 6), C(6, 8) are not collinear.");
        }
    }
}
