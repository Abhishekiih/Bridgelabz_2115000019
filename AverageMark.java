public class AverageMark {
    public static void main(String[] args) {
        // Marks obtained in each subject
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate the average percentage
        double average = (maths + physics + chemistry) / 3.0;

        // Print the result
        System.out.printf("Sam’s average mark in PCM is %.2f%n", average);
    }
}
