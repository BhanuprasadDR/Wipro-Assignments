import java.util.concurrent.LinkedBlockingQueue;

public class ChatProcessor {

    // Shared buffer with max capacity 5
    private static LinkedBlockingQueue<String> messageQueue = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {
        
        // Producer thread (adds messages)
        Thread producer = new Thread(() -> {
            int messageCount = 1;
            try {
                while (true) {
                    String message = "Message " + messageCount++;
                    messageQueue.put(message); // blocks if queue is full
                    System.out.println("Added: " + message);
                    Thread.sleep(500); // simulate delay in message creation
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread (reads messages)
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String message = messageQueue.take(); // blocks if queue is empty
                    System.out.println("Read: " + message);
                    Thread.sleep(1000); // simulate processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start both threads
        producer.start();
        consumer.start();
    }
}
