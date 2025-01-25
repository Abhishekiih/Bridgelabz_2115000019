import java.util.Scanner;

public class EmployeeBonusCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;
        
        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.println("Enter details for employee " + (i + 1) + ":");
                
                System.out.print("Enter salary: ");
                salary[i] = scanner.nextDouble();
                
                if (salary[i] <= 0) {
                    System.out.println("Invalid salary. Please enter a positive number.");
                    continue;
                }
                
                System.out.print("Enter years of service: ");
                yearsOfService[i] = scanner.nextDouble();
                
                if (yearsOfService[i] < 0) {
                    System.out.println("Invalid years of service. Please enter a non-negative number.");
                    continue;
                }
                
                break;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05; // 5% bonus
            } else {
                bonus[i] = salary[i] * 0.02; // 2% bonus
            }
            
            newSalary[i] = salary[i] + bonus[i];
            
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        
        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
