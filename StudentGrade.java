import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            double physics = -1, chemistry = -1, maths = -1;

            while (physics < 0) {
                System.out.print("Enter marks in Physics: ");
                physics = scanner.nextDouble();
                if (physics < 0) {
                    System.out.println("Marks must be positive. Please enter again.");
                }
            }

            while (chemistry < 0) {
                System.out.print("Enter marks in Chemistry: ");
                chemistry = scanner.nextDouble();
                if (chemistry < 0) {
                    System.out.println("Marks must be positive. Please enter again.");
                }
            }

            while (maths < 0) {
                System.out.print("Enter marks in Maths: ");
                maths = scanner.nextDouble();
                if (maths < 0) {
                    System.out.println("Marks must be positive. Please enter again.");
                }
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;

            double totalMarks = physics + chemistry + maths;
            percentages[i] = (totalMarks / 300) * 100;

            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }

        System.out.println("\nStudent Results:");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-15s\n", "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("%-10d%-10.2f%-10.2f%-10.2f%-15.2f%-15s\n", 
                i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}
