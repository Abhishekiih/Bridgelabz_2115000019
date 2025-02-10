import java.util.*;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private List<String> records = new ArrayList<>();

    public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
    }

    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public List<String> viewRecords() {
        return records;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public List<String> viewRecords() {
        return records;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient inPatient = new InPatient("P001", "John Doe", 45, 2000, 5);
        Patient outPatient = new OutPatient("P002", "Jane Smith", 30, 500);

        ((MedicalRecord) inPatient).addRecord("Surgery completed successfully.");
        ((MedicalRecord) outPatient).addRecord("Routine check-up completed.");

        displayPatientDetails(inPatient);
        displayPatientDetails(outPatient);
    }

    public static void displayPatientDetails(Patient patient) {
        System.out.println(patient.getPatientDetails() + ", Bill: " + patient.calculateBill());
    }
}
