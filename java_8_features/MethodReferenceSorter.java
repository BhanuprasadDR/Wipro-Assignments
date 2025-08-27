import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class MethodReferenceSorter {
    public static void main(String[] args) {
        // Create a list of strings to sort
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Zoe", "Michael", "Emma");
        
        System.out.println("Original list: " + names);
        
        // Sort using method reference - natural order (alphabetical)
        Collections.sort(names, String::compareToIgnoreCase);
        
        System.out.println("Sorted list (case-insensitive): " + names);
        
        // Alternative: Sort using method reference for case-sensitive comparison
        List<String> names2 = Arrays.asList("John", "alice", "Bob", "zoe", "Michael", "emma");
        System.out.println("\nOriginal list 2: " + names2);
        
        Collections.sort(names2, String::compareTo);
        
        System.out.println("Sorted list (case-sensitive): " + names2);
    }
}