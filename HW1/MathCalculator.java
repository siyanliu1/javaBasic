import java.util.*;

public class MathCalculator {
    public static void main(String[] args) {
        // Example 2-variable operations
        int x = 5, y = 7;
        System.out.println("Two-variable operations:");
        System.out.println("Addition: " + add(x, y));
        System.out.println("Subtraction: " + subtract(x, y));
        System.out.println("Multiplication: " + multiply(x, y));
        System.out.println("Division: " + divide(x, y));

        // Example 3-variable operations
        int z = 6;
        System.out.println("\nThree-variable operations:");
        System.out.println("Addition: " + add(x, y, z));
        System.out.println("Subtraction: " + subtract(x, y, z));
        System.out.println("Multiplication: " + multiply(x, y, z));
        System.out.println("Division: " + divide(x, y, z));

        // Processing an array of numbers and operators
        int[] input1 = {5, 6, 14, 7};
        String[] input2 = {"Add", "Sub", "Div"};
        System.out.println("\nComplex Calculation Result: " + evaluateExpression(input1, input2));
    }

    // Basic Operations for Two Variables
    public static int add(int a, int b) { return a + b; }
    public static int subtract(int a, int b) { return a - b; }
    public static int multiply(int a, int b) { return a * b; }
    public static int divide(int a, int b) { return a / b; }

    // Basic Operations for Three Variables
    public static int add(int a, int b, int c) { return a + b + c; }
    public static int subtract(int a, int b, int c) { return a - b - c; }
    public static int multiply(int a, int b, int c) { return a * b * c; }
    public static int divide(int a, int b, int c) { return a / b / c; }

    // Evaluate expression with precedence
    public static int evaluateExpression(int[] nums, String[] ops) {
        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        
        // Copy input to lists for modification
        for (int num : nums) numbers.add(num);
        for (String op : ops) operators.add(op);

        // First pass: Handle Multiplication and Division
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals("Mul") || operators.get(i).equals("Div")) {
                int num1 = numbers.get(i);
                int num2 = numbers.get(i + 1);
                int result = operators.get(i).equals("Mul") ? num1 * num2 : (int) Math.floor((double) num1 / num2);
                
                // Replace processed numbers and remove the used operator
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--; // Adjust index after removal
            }
        }

        // Second pass: Handle Addition and Subtraction
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals("Add")) {
                result += numbers.get(i + 1);
            } else if (operators.get(i).equals("Sub")) {
                result -= numbers.get(i + 1);
            }
        }

        return result;
    }
}
