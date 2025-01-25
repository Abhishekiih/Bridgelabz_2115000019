import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to generate its multiplication table (from 6 to 9): ");
        int number = scanner.nextInt();
        int[] multiplicationResult = new int[4];

        for (int i = 0; i < 4; i++) {
            multiplicationResult[i] = number * (6 + i);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(number + " * " + (6 + i) + " = " + multiplicationResult[i]);
        }

    }
}
