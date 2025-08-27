import java.util.ArrayDeque;
import java.util.Scanner;

public class GroceryLineShuffle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        System.out.println("Enter 5 customer names:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Customer " + (i + 1) + ": ");
            String name = scanner.nextLine();

            if (name.length() % 2 == 0) {
                // Even length → add to front
                queue.addFirst(name);
            } else {
                // Odd length → add to end
                queue.addLast(name);
            }
        }

        // Serve customers in current order
        System.out.println("\nServing customers in order:");
        while (!queue.isEmpty()) {
            System.out.println(queue.removeFirst());
        }

        scanner.close();
    }
}
