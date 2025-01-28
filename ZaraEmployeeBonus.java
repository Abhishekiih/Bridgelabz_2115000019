import java.util.Random;

public class ZaraEmployeeBonus {

    public static double[][] determineSalaryAndYearsOfService() {
        Random rand = new Random();
        double[][] employeeData = new double[10][2];

        for (int i = 0; i < 10; i++) {
            double salary = 10000 + rand.nextInt(90000); // Random salary between 10000 and 99999
            int yearsOfService = rand.nextInt(20); // Random years of service between 0 and 19
            employeeData[i][0] = salary;
            employeeData[i][1] = yearsOfService;
        }
        return employeeData;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] newEmployeeData = new double[10][3];

        for (int i = 0; i < 10; i++) {
            double oldSalary = employeeData[i][0];
            int yearsOfService = (int) employeeData[i][1];
            double bonus = 0;

            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05; // 5% bonus if more than 5 years
            } else {
                bonus = oldSalary * 0.02; // 2% bonus if less than 5 years
            }

            double newSalary = oldSalary + bonus;

            newEmployeeData[i][0] = oldSalary;
            newEmployeeData[i][1] = newSalary;
            newEmployeeData[i][2] = bonus;
        }

        return newEmployeeData;
    }

    public static void calculateAndDisplayTotal(double[][] newEmployeeData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Old Salary\tNew Salary\tBonus");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            double oldSalary = newEmployeeData[i][0];
            double newSalary = newEmployeeData[i][1];
            double bonus = newEmployeeData[i][2];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%.2f\t%.2f\t%.2f\n", oldSalary, newSalary, bonus);
        }

        System.out.println("---------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
    }

    public static void main(String[] args) {
        double[][] employeeData = determineSalaryAndYearsOfService();
        double[][] newEmployeeData = calculateNewSalaryAndBonus(employeeData);
        calculateAndDisplayTotal(newEmployeeData);
    }
}
