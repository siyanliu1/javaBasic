import java.util.Scanner;

public class MinutesToYearsDays {
    public static void main(String[] args) {
        // Constants for calculations
        final int MINUTES_IN_A_DAY = 24 * 60;
        final int MINUTES_IN_A_YEAR = 365 * MINUTES_IN_A_DAY;

        // Scanner to take user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input the number of minutes: ");
        long minutes = scanner.nextLong();
        
        // Convert minutes to years and days
        long years = minutes / MINUTES_IN_A_YEAR;
        long remainingMinutes = minutes % MINUTES_IN_A_YEAR;
        long days = remainingMinutes / MINUTES_IN_A_DAY;

        // Display the result
        System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days.");
        
        scanner.close();
    }
}
