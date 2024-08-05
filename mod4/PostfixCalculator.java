import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
 * This class implements a calculator for evaluating postfix expressions.
 */
public class PostfixCalculator {

    /**
     * Evaluates a postfix expression and returns the result.
     * @param postfixExpression The postfix expression to evaluate.
     * @return The result of the evaluation.
     * @throws IllegalArgumentException If the expression is invalid.
     */
    public int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfixExpression.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                // Check if there are enough operands for the operator
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: insufficient operands");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                // If not an operator, try to parse as an integer
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid token: " + token);
                }
            }
        }

        // Check if there's exactly one result left on the stack
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: too many operands");
        }

        return stack.pop();
    }

    /**
     * Checks if a token is a valid operator.
     * @param token The token to check.
     * @return true if the token is an operator, false otherwise.
     */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    /**
     * Performs the arithmetic operation specified by the operator.
     * @param operator The operator to apply.
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @return The result of the operation.
     * @throws ArithmeticException If division or modulo by zero is attempted.
     * @throws IllegalArgumentException If an unknown operator is provided.
     */
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

    /**
     * Reads expressions from a file and evaluates each one.
     * @param filename The name of the file containing the expressions.
     */
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

    /**
     * Prompts the user for the file path and returns it.
     * @return The file path entered by the user.
     */
    public static String getFilePathFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the full path to your expressions.txt file:");
        String filePath = scanner.nextLine().trim();
        
        // Remove surrounding quotes if present
        if ((filePath.startsWith("\"") && filePath.endsWith("\"")) || 
            (filePath.startsWith("'") && filePath.endsWith("'"))) {
            filePath = filePath.substring(1, filePath.length() - 1);
        }
        
        return filePath;
    }

    /**
     * Main method to demonstrate the functionality of the PostfixCalculator.
     */
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
