import java.util.concurrent.LinkedBlockingQueue;

// Task class
class Task {
    int id;
    String name;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name='" + name + "'}";
    }
}

public class StageBasedTaskRunner {

    // Two thread-safe queues for stages
    private static LinkedBlockingQueue<Task> stage1Queue = new LinkedBlockingQueue<>();
    private static LinkedBlockingQueue<Task> stage2Queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        // Producer - adds tasks to Stage 1
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Task task = new Task(i, "Task-" + i);
                    stage1Queue.put(task);
                    System.out.println("Added to Stage 1: " + task);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Stage 1 Processor - moves even tasks to Stage 2
        Thread stage1Processor = new Thread(() -> {
            try {
                while (true) {
                    Task task = stage1Queue.take();
                    System.out.println("Processing in Stage 1: " + task);
                    Thread.sleep(500);
                    if (task.id % 2 == 0) {
                        stage2Queue.put(task);
                        System.out.println("Moved to Stage 2: " + task);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Stage 2 Processor - final processing
        Thread stage2Processor = new Thread(() -> {
            try {
                while (true) {
                    Task task = stage2Queue.take();
                    System.out.println("Processing in Stage 2: " + task);
                    Thread.sleep(700);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start threads
        producer.start();
        stage1Processor.start();
        stage2Processor.start();
    }
}
