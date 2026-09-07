public class PatientBST {

    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    private Node root;

    public boolean insert(Patient patient) {
        if (search(patient.getPatientId()) != null) {
            return false;
        }

        root = insertRecursive(root, patient);
        return true;
    }

    private Node insertRecursive(Node current, Patient patient) {

        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRecursive(current.left, patient);
        } else {
            current.right = insertRecursive(current.right, patient);
        }

        return current;
    }

    public Patient search(int patientId) {
        Node current = root;

        while (current != null) {

            if (patientId == current.patient.getPatientId()) {
                return current.patient;
            }

            if (patientId < current.patient.getPatientId()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public boolean delete(int patientId) {

        if (search(patientId) == null) {
            return false;
        }

        root = deleteRecursive(root, patientId);
        return true;
    }

    private Node deleteRecursive(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {

            current.left = deleteRecursive(current.left, patientId);

        } else if (patientId > current.patient.getPatientId()) {

            current.right = deleteRecursive(current.right, patientId);

        } else {

            // Case 1: No child
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (current.left == null) {
                return current.right;
            }

            // Case 3: Only left child
            if (current.right == null) {
                return current.left;
            }

            // Case 4: Two children
            Node smallest = findSmallest(current.right);
            current.patient = smallest.patient;
            current.right =
                    deleteRecursive(current.right,
                            smallest.patient.getPatientId());
        }

        return current;
    }

    private Node findSmallest(Node node) {

        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void displayInOrder() {

        if (root == null) {
            System.out.println("No patients registered.");
            return;
        }

        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node current) {

        if (current != null) {

            inOrderRecursive(current.left);

            System.out.println(current.patient);

            inOrderRecursive(current.right);
        }
    }
}