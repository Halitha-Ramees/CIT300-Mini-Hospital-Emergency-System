import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {

    private Queue<Patient> queue;

    public EmergencyQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Patient patient) {
        queue.offer(patient);
        System.out.println("Patient added to emergency queue.");
    }

    public Patient dequeue() {

        if (queue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        return queue.poll();
    }

    public void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n--- Emergency Waiting Queue ---");

        int position = 1;

        for (Patient patient : queue) {

            System.out.println(
                    position + ". "
                    + patient.getPatientId()
                    + " - "
                    + patient.getPatientName()
            );

            position++;
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
