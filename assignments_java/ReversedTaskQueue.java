import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class ReversedTaskQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> taskList = new LinkedList<>();

        // Take 4 tasks as input
        System.out.println("Enter 4 task names:");
        for (int i = 0; i < 4; i++) {
            String task = scanner.nextLine();

            // If task ends with '!', add to front; else, add to end
            if (task.endsWith("!")) {
                taskList.addFirst(task);
            } else {
                taskList.addLast(task);
            }
        }

        // Print the list in reverse order
        System.out.println("\nTasks in reverse order:");
        ListIterator<String> iterator = taskList.listIterator(taskList.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        scanner.close();
    }
}
