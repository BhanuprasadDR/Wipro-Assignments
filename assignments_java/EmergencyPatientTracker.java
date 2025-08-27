import java.util.Comparator;
import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;
    long arrivalTime;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', severity=" + severity + "}";
    }
}

public class EmergencyPatientTracker {

    private static final int MAX_CAPACITY = 5;

    // PriorityQueue with custom comparator
    private PriorityQueue<Patient> patientQueue = new PriorityQueue<>(
        Comparator.comparingInt((Patient p) -> p.severity) // lowest severity first
                  .thenComparingLong(p -> p.arrivalTime)   // then oldest first
    );

    // Add patient if not full
    public void addPatient(Patient patient) {
        if (patientQueue.size() < MAX_CAPACITY) {
            patientQueue.offer(patient);
            System.out.println("Added: " + patient);
        } else {
            System.out.println("Queue full. Cannot add: " + patient);
        }
    }

    // Treat next patient
    public void treatPatient() {
        Patient patient = patientQueue.poll();
        if (patient != null) {
            System.out.println("Treating: " + patient);
        } else {
            System.out.println("No patients to treat.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EmergencyPatientTracker tracker = new EmergencyPatientTracker();

        tracker.addPatient(new Patient("Alice", 3));
        Thread.sleep(10);
        tracker.addPatient(new Patient("Bob", 1));
        Thread.sleep(10);
        tracker.addPatient(new Patient("Charlie", 2));
        Thread.sleep(10);
        tracker.addPatient(new Patient("David", 1));
        Thread.sleep(10);
        tracker.addPatient(new Patient("Eva", 2));
        tracker.addPatient(new Patient("Frank", 4)); // should be skipped (full)

        System.out.println("\n--- Treating patients ---");
        tracker.treatPatient();
        tracker.treatPatient();
        tracker.treatPatient();
        tracker.treatPatient();
        tracker.treatPatient();
        tracker.treatPatient(); // no patients left
    }
}
