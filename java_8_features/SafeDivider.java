import java.util.Optional;

public class SafeDivider {
    
    // Method to perform safe division
    public static Optional<Double> divide(int numerator, int denominator) {
        if (denominator == 0) {
            return Optional.empty(); // No result possible
        }
        return Optional.of((double) numerator / denominator);
    }

    public static void main(String[] args) {
        // Test case 1: Valid division
        Optional<Double> result1 = divide(10, 2);
        System.out.println(result1.isPresent() ? "Result: " + result1.get() : "Not Allowed");

        // Test case 2: Division by zero
        Optional<Double> result2 = divide(10, 0);
        System.out.println(result2.isPresent() ? "Result: " + result2.get() : "Not Allowed");
    }
}
