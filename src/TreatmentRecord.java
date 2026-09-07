public class TreatmentRecord {

    private int patientId;
    private String patientName;
    private String doctorName;
    private String treatment;
    private String date;

    public TreatmentRecord(int patientId, String patientName,
                           String doctorName, String treatment,
                           String date) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatment = treatment;
        this.date = date;
    }

    @Override
    public String toString() {

        return "Patient ID: " + patientId
                + " | Patient: " + patientName
                + " | Doctor: " + doctorName
                + " | Treatment: " + treatment
                + " | Date: " + date;
    }
}
