import java.util.Scanner;

public class CalendarDisplay {

    // Method to get the name of the month from the month number
    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    // Method to check if the year is a leap year
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    // Method to get the number of days in a month
    public static int getNumberOfDays(int month, int year) {
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
        if (month == 2 && isLeapYear(year)) {
            return 29; // February in a leap year
        }
        return daysInMonth[month - 1];
    }

    // Method to get the first day of the month using the Gregorian Calendar formula
    public static int getFirstDayOfMonth(int month, int year) {
        int y = year;
        int m = month;
        if (m == 1 || m == 2) {
            m += 12;
            y--;
        }
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7; // 1 is the first day of the month
        return d0;
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        // Get the month name and number of days
        String monthName = getMonthName(month);
        int numberOfDays = getNumberOfDays(month, year);

        // Print the month and year heading
        System.out.println("     " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Get the first day of the month
        int firstDay = getFirstDayOfMonth(month, year);

        // Print leading spaces for the first day of the month
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Print the days of the month
        int day = 1;
        for (int i = firstDay; i < 7; i++) {
            System.out.printf("%3d ", day++);
        }
        System.out.println();

        // Print the rest of the days of the month
        for (int i = day; i <= numberOfDays; i++) {
            System.out.printf("%3d ", i);
            if ((i + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the month and year
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // Display the calendar
        displayCalendar(month, year);
    }
}
