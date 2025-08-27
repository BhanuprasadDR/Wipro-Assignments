import java.util.List;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class ParallelSquarePrinter {
    public static void main(String[] args) {
        // Create a list of numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            numbers.add(i);
        }

        System.out.println("Printing squares using parallel stream:");
        System.out.println("----------------------------------------");
        
        // Use parallel stream to print squares
        numbers.parallelStream()
               .forEach(number -> {
                   int square = number * number;
                   System.out.println("Square of " + number + " is: " + square + 
                                    " (Thread: " + Thread.currentThread().getName() + ")");
               });
        
        System.out.println("----------------------------------------");
        System.out.println("All squares printed!");
    }
}