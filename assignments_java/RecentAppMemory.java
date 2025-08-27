import java.util.LinkedList;
import java.util.Scanner;

public class RecentAppMemory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> recentApps = new LinkedList<>();

        System.out.println("Open 5 apps (enter app names):");

        for (int i = 0; i < 5; i++) {
            System.out.print("App " + (i + 1) + ": ");
            String app = scanner.nextLine();

            // If already in the list, remove it (no duplicates)
            if (recentApps.contains(app)) {
                recentApps.remove(app);
            }

            // Add to the top (front) of the list
            recentApps.addFirst(app);
        }

        // Display the final recent app list
        System.out.println("\nRecent Apps (most recent first):");
        for (String app : recentApps) {
            System.out.println(app);
        }

        scanner.close();
    }
}
