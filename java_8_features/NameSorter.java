import java.util.*;

public class NameSorter {
    public static void main(String[] args) {
        // Step 1: Create a list of names
        List<String> names = Arrays.asList("Ravi", "Anita", "Suresh", "Meena", "Kiran");

        // Step 2: Sort using lambda expression
        Collections.sort(names, (name1, name2) -> name1.compareTo(name2));

        // Step 3: Print sorted names
        System.out.println("Sorted Names:");
        names.forEach(System.out::println);
    }
}
