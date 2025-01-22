public class PenDistribution {
    public static void main(String[] args) {
        // Total number of pens and students
        int totalPens = 14;
        int totalStudents = 3;

        // Calculate pens per student and the remaining pens
        int pensPerStudent = totalPens / totalStudents;
        int remainingPens = totalPens % totalStudents;

        // Display the results
        System.out.println("The Pen Per Student is "+ pensPerStudent + " and the remaining pen not distributed is " + remainingPens);
    }
}
