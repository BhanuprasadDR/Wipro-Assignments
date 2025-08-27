import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FrequencyMapper {
    public static void main(String[] args) {
        // Create a list with duplicate names
        List<String> names = Arrays.asList(
            "Alice", "Bob", "Charlie", "Alice", "David", 
            "Bob", "Alice", "Eve", "Charlie", "Bob",
            "Alice", "Frank", "David", "Alice", "Bob"
        );

        System.out.println("Original list of names:");
        System.out.println(names);
        System.out.println("\nName frequency count:");
        System.out.println("---------------------");

        // Use stream with groupingBy and counting to create frequency map
        Map<String, Long> frequencyMap = names.stream()
                .collect(Collectors.groupingBy(
                    name -> name, // group by the name itself
                    Collectors.counting() // count occurrences
                ));

        // Print the frequency map
        frequencyMap.forEach((name, count) -> 
            System.out.println(name + ": " + count + " time(s)"));
    }
}