public class NumberChecker5 {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int greatestFactor(int number) {
        int[] factors = findFactors(number);
        return factors[factors.length - 1];  // The last element is the greatest factor
    }

    public static int sumOfFactors(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int productOfFactors(int number) {
        int[] factors = findFactors(number);
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double productOfCubeOfFactors(int number) {
        int[] factors = findFactors(number);
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int sum = sumOfFactors(number) - number;  // Exclude the number itself
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int sum = sumOfFactors(number) - number;  // Exclude the number itself
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int sum = sumOfFactors(number) - number;  // Exclude the number itself
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int temp = number;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    private static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int number = 28;

        System.out.println("Number: " + number);

        int[] factors = findFactors(number);
        System.out.println("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        int greatestFactor = greatestFactor(number);
        System.out.println("Greatest Factor: " + greatestFactor);

        int sumFactors = sumOfFactors(number);
        System.out.println("Sum of Factors: " + sumFactors);

        int productFactors = productOfFactors(number);
        System.out.println("Product of Factors: " + productFactors);

        double productCubeFactors = productOfCubeOfFactors(number);
        System.out.println("Product of Cube of Factors: " + productCubeFactors);

        boolean perfect = isPerfectNumber(number);
        System.out.println("Is Perfect Number? " + perfect);

        boolean abundant = isAbundantNumber(number);
        System.out.println("Is Abundant Number? " + abundant);

        boolean deficient = isDeficientNumber(number);
        System.out.println("Is Deficient Number? " + deficient);

        boolean strong = isStrongNumber(number);
        System.out.println("Is Strong Number? " + strong);
    }
}
