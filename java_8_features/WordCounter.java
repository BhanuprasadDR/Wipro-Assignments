import java.util.Arrays;
import java.util.List;

public class WordCounter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Amy");
        long count = names.stream()
                          .filter(name -> name.length() > 5)
                          .count();
        System.out.println(count);
    }
}