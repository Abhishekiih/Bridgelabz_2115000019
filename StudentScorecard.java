import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generateScores(int numberOfStudents) {
        Random random = new Random();
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = random.nextInt(41) + 60; // Random 2-digit scores between 60 and 100
            }
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        int numberOfStudents = scores.length;
        double[][] stats = new double[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = Math.round((total / 3.0) * 100.0) / 100.0;
            double percentage = Math.round((total / 3.0) * 100.0) / 3.0;
            stats[i][0] = total;
            stats[i][1] = average;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            String grade = calculateGrade(stats[i][2]);
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] +
                    "\t" + (int) stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "\t" + grade);
        }
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        int[][] scores = generateScores(numberOfStudents);
        double[][] stats = calculateStats(scores);
        displayScorecard(scores, stats);
    }
}