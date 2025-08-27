// Step 1: Define a functional interface
@FunctionalInterface
interface MessagePrinter {
    void printMessage(String message);
}

public class GreetingsPrinter {

    // Step 2: Method that accepts functional interface
    public static void showGreeting(String name, MessagePrinter printer) {
        printer.printMessage("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        // Step 3: Pass lambda function as MessagePrinter
        MessagePrinter printer = msg -> System.out.println(msg);

        // Step 4: Call method
        showGreeting("Ravi", printer);
        showGreeting("Anita", printer);
    }
}
