package CT_ASSIGNMENTS;

import java.util.Scanner;

public class GradeStatistics {
	public static void main(String[] args) {
    System.out.println("This program will calculate the average score, minimum score, and maximum score of 10 student grades.");
		Scanner input = new Scanner(System.in);

        double sum = 0;
        double maximum = Double.MIN_VALUE;
        double minimum = Double.MAX_VALUE;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter grade " + i + ": ");
            if (input.hasNextDouble()) {
                double grade = input.nextDouble();
                sum += grade;
                if (grade > maximum) {
                    maximum = grade;
                }
                if (grade < minimum) {
                    minimum = grade;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid grade.");
                input.next(); // Clear the invalid input from the scanner
                i--; // Decrement the loop counter to repeat the input for this grade
            }
        }

        double average = sum / 10;

        System.out.println("Average: " + average);
        System.out.println("Maximum: " + maximum);
        System.out.println("Minimum: " + minimum);

        input.close();
    }
}

