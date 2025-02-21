import java.io.*;

public class StudentDataStream {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        // Writing student details to a binary file
        writeStudentData();

        // Reading and displaying student details from the file
        readStudentData();
    }

    private static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            // Writing student records
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Alice Johnson"); // Name
            dos.writeDouble(3.75); // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob Smith");
            dos.writeDouble(3.90);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nRetrieving Student Data:");

            while (dis.available() > 0) {  // Ensure we read only available data
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
