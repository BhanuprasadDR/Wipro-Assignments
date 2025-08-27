import java.util.Scanner;
import java.util.Stack;

public class UndoStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> commandStack = new Stack<>();

        // Step 1: Add 3 commands
        System.out.println("Enter 3 commands:");
        for (int i = 0; i < 3; i++) {
            String command = scanner.nextLine();
            commandStack.push(command);
        }

        // Step 2: Undo (pop the last command)
        String undoneCommand = commandStack.pop();
        System.out.println("Undone command: " + undoneCommand);

        // Step 3: Redo (re-add in reverse)
        String reversedCommand = new StringBuilder(undoneCommand).reverse().toString();
        commandStack.push(reversedCommand);
        System.out.println("Redone (reversed) command added: " + reversedCommand);

        // Print final stack
        System.out.println("Final stack: " + commandStack);

        scanner.close();
    }
}
