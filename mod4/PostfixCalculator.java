import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class PostfixCalculator {
    public int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfixExpression.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: insufficient operands");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid token: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: too many operands");
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    private int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case "%":
                if (operand2 == 0) {
                    throw new ArithmeticException("Modulo by zero");
                }
                return operand1 % operand2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public void evaluateExpressionsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int result = evaluatePostfix(line);
                    System.out.println("Expression: " + line);
                    System.out.println("Result: " + result);
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println("Expression: " + line);
                    System.out.println("Error: " + e.getMessage());
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static String getFilePathFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the full path to your expressions.txt file:");
        String filePath = scanner.nextLine();
        return filePath;
    }

    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();

        // Example 1: Valid Expression
        String expression1 = "4 2 * 3 +";
        System.out.println("Result 1: " + calculator.evaluatePostfix(expression1));

        // Example 2: Valid Expression
        String expression2 = "5 3 + 7 *";
        System.out.println("Result 2: " + calculator.evaluatePostfix(expression2));

        // Example 3: Invalid Expression
        String expression3 = "4 2 * +"; // Missing operand
        try {
            System.out.println("Result 3: " + calculator.evaluatePostfix(expression3));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Get file path from user
        String filePath = getFilePathFromUser();

        // Debug information
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        File file = new File(filePath);
        System.out.println("File exists: " + file.exists());
        System.out.println("File absolute path: " + file.getAbsolutePath());

        // Example 4: Reading from file
        System.out.println("\nReading expressions from file:");
        calculator.evaluateExpressionsFromFile(filePath);
    }
}
