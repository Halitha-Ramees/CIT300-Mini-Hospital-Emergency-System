import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    // Visit history for the currently selected patient
    static VisitLinkedList visitHistory = new VisitLinkedList();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("----------------------------------------------");
        System.out.println("     MINI HOSPITAL EMERGENCY MANAGEMENT");
        System.out.println("----------------------------------------------");

        while (running) {

            displayMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    patientManagement();
                    break;

                case 2:
                    emergencyQueueMenu();
                    break;

                case 3:
                    treatmentHistoryMenu();
                    break;

                case 4:
                    visitHistoryMenu();
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // -----------------------
    // MAIN MENU
    // -----------------------

    static void displayMainMenu() {

        System.out.println("\n----------------------------------------------");
        System.out.println("                 MAIN MENU");
        System.out.println("------------------------------------------------");
        System.out.println("1. Patient Management");
        System.out.println("2. Emergency Queue");
        System.out.println("3. Treatment History");
        System.out.println("4. Patient Visit History");
        System.out.println("5. Exit");
        System.out.println("----------------------------------------------");
    }

    // -----------------------
    // PATIENT MANAGEMENT
    // -----------------------

    static void patientManagement() {

        boolean back = false;

        while (!back) {

            System.out.println("\n----------- PATIENT MANAGEMENT -----------");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display Patients");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    patientBST.displayInOrder();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addPatient() {

        System.out.println("\n--- Add Patient ---");

        int id = readInt("Enter Patient ID: ");

        if (patientBST.search(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        int age = readInt("Enter Age: ");

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient =
                new Patient(id, name, age, contact, condition);

        patientBST.insert(patient);

        System.out.println("Patient successfully registered.");
    }

    static void searchPatient() {

        System.out.println("\n--- Search Patient ---");

        int id = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("Patient found:");
            System.out.println(patient);
        }
    }

    static void deletePatient() {

        System.out.println("\n--- Delete Patient ---");

        int id = readInt("Enter Patient ID: ");

        boolean deleted = patientBST.delete(id);

        if (deleted) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    // -----------------------
    // EMERGENCY QUEUE
    // -----------------------

    static void emergencyQueueMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n----------- EMERGENCY QUEUE -----------");
            System.out.println("1. Add Patient to Queue");
            System.out.println("2. Treat Next Patient");
            System.out.println("3. Display Waiting Patients");
            System.out.println("4. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    enqueuePatient();
                    break;

                case 2:
                    treatNextPatient();
                    break;

                case 3:
                    emergencyQueue.displayQueue();
                    break;

                case 4:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void enqueuePatient() {

        int id = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient does not exist.");
            System.out.println("Please register the patient first.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    static void treatNextPatient() {

        Patient patient = emergencyQueue.dequeue();

        if (patient == null) {
            return;
        }

        System.out.println("\nPatient selected for treatment:");
        System.out.println(patient);

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        System.out.print("Enter Treatment Date: ");
        String date = scanner.nextLine();

        TreatmentRecord record =
                new TreatmentRecord(
                        patient.getPatientId(),
                        patient.getPatientName(),
                        doctor,
                        treatment,
                        date
                );

        treatmentStack.push(record);

        System.out.println("Treatment completed and recorded.");
    }

    // -----------------------
    // TREATMENT STACK
    // -----------------------

    static void treatmentHistoryMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n----------- TREATMENT HISTORY -----------");
            System.out.println("1. Add Completed Treatment");
            System.out.println("2. Remove Latest Treatment");
            System.out.println("3. Display Treatment History");
            System.out.println("4. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addTreatment();
                    break;

                case 2:
                    removeTreatment();
                    break;

                case 3:
                    treatmentStack.displayStack();
                    break;

                case 4:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addTreatment() {

        int id = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        TreatmentRecord record =
                new TreatmentRecord(
                        patient.getPatientId(),
                        patient.getPatientName(),
                        doctor,
                        treatment,
                        date
                );

        treatmentStack.push(record);
    }

    static void removeTreatment() {

        TreatmentRecord record = treatmentStack.pop();

        if (record != null) {
            System.out.println("Removed latest treatment:");
            System.out.println(record);
        }
    }

    // -----------------------
    // VISIT HISTORY
    // -----------------------

    static void visitHistoryMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n----------- PATIENT VISIT HISTORY -----------");
            System.out.println("1. Add Visit");
            System.out.println("2. Remove Visit");
            System.out.println("3. Search Visit");
            System.out.println("4. Display Visit History");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addVisit();
                    break;

                case 2:
                    removeVisit();
                    break;

                case 3:
                    searchVisit();
                    break;

                case 4:
                    visitHistory.displayVisits();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addVisit() {

        System.out.println("\n--- Add Visit ---");

        System.out.print("Enter Visit ID: ");
        String visitId = scanner.nextLine();

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit =
                new Visit(
                        visitId,
                        date,
                        doctor,
                        diagnosis,
                        treatment
                );

        visitHistory.addVisit(visit);

        System.out.println("Visit added successfully.");
    }

    static void removeVisit() {

        System.out.print("Enter Visit ID to remove: ");
        String visitId = scanner.nextLine();

        boolean removed =
                visitHistory.removeVisit(visitId);

        if (removed) {
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit not found.");
        }
    }

    static void searchVisit() {

        System.out.print("Enter Visit ID to search: ");
        String visitId = scanner.nextLine();

        Visit visit =
                visitHistory.searchVisit(visitId);

        if (visit == null) {
            System.out.println("Visit not found.");
        } else {
            System.out.println("Visit found:");
            System.out.println(visit);
        }
    }

    // -----------------------
    // INPUT VALIDATION
    // -----------------------

    static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }
}