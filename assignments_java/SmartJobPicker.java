import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

// Define the Job class
class Job {
    String name;
    int urgency; // 1 (most urgent) to 5 (least urgent)

    Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return name + " (Urgency: " + urgency + ")";
    }
}

public class SmartJobPicker {
    public static void main(String[] args) {
        // Define the comparator: by urgency, then by shorter name
        Comparator<Job> jobComparator = (a, b) -> {
            if (a.urgency != b.urgency) {
                return Integer.compare(a.urgency, b.urgency); // lower urgency first
            } else {
                return Integer.compare(a.name.length(), b.name.length()); // shorter name first
            }
        };

        // PriorityQueue with custom comparator
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(jobComparator);

        // Take 5 job inputs from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 jobs with name and urgency (1-5):");

        for (int i = 0; i < 5; i++) {
            System.out.print("Job name: ");
            String name = scanner.nextLine();

            System.out.print("Urgency (1-5): ");
            int urgency = Integer.parseInt(scanner.nextLine());

            jobQueue.add(new Job(name, urgency));
        }

        // Serve jobs in priority order
        System.out.println("\nJobs served in priority:");
        while (!jobQueue.isEmpty()) {
            System.out.println(jobQueue.poll());
        }

        scanner.close();
    }
}
