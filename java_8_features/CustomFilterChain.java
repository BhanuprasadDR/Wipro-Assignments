import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomFilterChain {
    public static void main(String[] args) {
        // Create a list of names
        List<String> names = Arrays.asList(
            "Alice", "Amanda", "Anna", "Barbara", "Clara",
            "Diana", "Eva", "Fiona", "Gloria", "Hannah",
            "Irina", "Jessica", "Laura", "Maria", "Nina"
        );

        System.out.println("Original list of names:");
        System.out.println(names);
        System.out.println();

        // Create custom predicates
        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> endsWithA = name -> name.endsWith("a");

        // Chain predicates using different combinations
        System.out.println("1. Names starting with 'A':");
        List<String> startsWithAList = filterNames(names, startsWithA);
        System.out.println(startsWithAList);
        System.out.println();

        System.out.println("2. Names ending with 'a':");
        List<String> endsWithAList = filterNames(names, endsWithA);
        System.out.println(endsWithAList);
        System.out.println();

        System.out.println("3. Names starting with 'A' AND ending with 'a':");
        List<String> startsWithAAndEndsWithA = filterNames(names, startsWithA.and(endsWithA));
        System.out.println(startsWithAAndEndsWithA);
        System.out.println();

        System.out.println("4. Names starting with 'A' OR ending with 'a':");
        List<String> startsWithAOrEndsWithA = filterNames(names, startsWithA.or(endsWithA));
        System.out.println(startsWithAOrEndsWithA);
        System.out.println();

        System.out.println("5. Names NOT starting with 'A':");
        List<String> notStartsWithA = filterNames(names, startsWithA.negate());
        System.out.println(notStartsWithA);
        System.out.println();

        System.out.println("6. Complex chain: (starts with 'A' OR ends with 'a') AND length > 4:");
        Predicate<String> lengthGreaterThan4 = name -> name.length() > 4;
        List<String> complexFilter = filterNames(names, 
            (startsWithA.or(endsWithA)).and(lengthGreaterThan4));
        System.out.println(complexFilter);
    }

    // Helper method to filter names using a predicate
    private static List<String> filterNames(List<String> names, Predicate<String> predicate) {
        return names.stream()
                   .filter(predicate)
                   .collect(Collectors.toList());
    }
}