import java.util.ArrayDeque;
import java.util.Scanner;

public class LimitedChatHistory {
    public static void main(String[] args) {
        ArrayDeque<String> chatHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter chat messages (type 'exit' to stop):");

        while (true) {
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            // Maintain only last 4 messages
            if (chatHistory.size() == 4) {
                chatHistory.removeFirst(); // Remove oldest
            }

            chatHistory.addLast(message); // Add new to end
        }

        System.out.println("\nLast 4 messages in chat:");
        for (String msg : chatHistory) {
            System.out.println(msg);
        }

        scanner.close();
    }
}
