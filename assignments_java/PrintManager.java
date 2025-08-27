import java.util.concurrent.ArrayBlockingQueue;

public class PrintManager {

    private ArrayBlockingQueue<String> printQueue;

    public PrintManager() {
        // Capacity of 3
        printQueue = new ArrayBlockingQueue<>(3);
    }

    
    public void addJob(String jobName) {
        boolean added = printQueue.offer(jobName); // offer() won't block
        if (added) {
            System.out.println("Added job: " + jobName);
        } else {
            System.out.println("Queue full. Skipping job: " + jobName);
        }
    }

    // Print one job at a time
    public void printJob() {
        String job = printQueue.poll(); // poll() removes head or returns null if empty
        if (job != null) {
            System.out.println("Printing: " + job);
        } else {
            System.out.println("No jobs to print.");
        }
    }

    public static void main(String[] args) {
        PrintManager pm = new PrintManager();

        pm.addJob("Job1");
        pm.addJob("Job2");
        pm.addJob("Job3");
        pm.addJob("Job4"); // skipped

        pm.printJob();
        pm.printJob();

        pm.addJob("Job5");
        pm.addJob("Job6");

        pm.printJob();
        pm.printJob();
        pm.printJob();
    }
}
