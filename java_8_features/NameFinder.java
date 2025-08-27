import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameFinder {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Amy");
        List<String> aNames = names.stream()
                                  .filter(name -> name.startsWith("A"))
                                  .collect(Collectors.toList());
        System.out.println(aNames);
    }
}