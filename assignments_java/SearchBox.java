import java.util.ArrayDeque;
import java.util.Scanner;

public class SearchBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> searchHistory = new ArrayDeque<>();

        System.out.println("Enter search terms (we'll simulate 6 searches):");

        for (int i = 0; i < 6; i++) {
            System.out.print("Search: ");
            String term = scanner.nextLine();

            // If already 3 terms, remove the oldest
            if (searchHistory.size() == 3) {
                searchHistory.removeFirst();
            }

            // Add the new term to the end (most recent)
            searchHistory.addLast(term);

            // Print current search history
            System.out.println("Recent searches: " + searchHistory);
        }

        scanner.close();
    }
}
