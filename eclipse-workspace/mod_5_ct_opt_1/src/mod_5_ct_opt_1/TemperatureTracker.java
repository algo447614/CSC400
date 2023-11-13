package mod_5_ct_opt_1;
import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<String> daysOfWeek = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();


        populateData(daysOfWeek, temperatures, scanner);


        System.out.println("Enter a day of the week (Monday through Sunday) or 'week' for weekly average:");
        String userDay = scanner.nextLine();

        displayTemperature(userDay, daysOfWeek, temperatures);

        scanner.close();
    }

    private static void populateData(ArrayList<String> daysOfWeek, ArrayList<Double> temperatures, Scanner scanner) {
        String[] daysArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (String day : daysArray) {
            daysOfWeek.add(day);
            System.out.print("Enter temperature for " + day + ": ");
            double temperature = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character after reading the temperature
            temperatures.add(temperature);
        }
    }

    private static void displayTemperature(String userDay, ArrayList<String> daysOfWeek, ArrayList<Double> temperatures) {
        if (userDay.equalsIgnoreCase("week")) {
            double weeklyAverage = calculateWeeklyAverage(temperatures);
            for (int i = 0; i < daysOfWeek.size(); i++) {
                System.out.println(daysOfWeek.get(i) + ": " + temperatures.get(i) + " degrees");
            }
            System.out.println("Weekly Average: " + weeklyAverage + " degrees");
        } else {
            int index = daysOfWeek.indexOf(userDay);
            if (index != -1) {
                System.out.println(userDay + ": " + temperatures.get(index) + " degrees");
            } else {
                System.out.println("Invalid input. Please enter a valid day of the week.");
            }
        }
    }

    private static double calculateWeeklyAverage(ArrayList<Double> temperatures) {
        double sum = 0;
        for (double temperature : temperatures) {
            sum += temperature;
        }
        return sum / temperatures.size();
    }
}
