import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class PatientFile {

    public static void main(String[] args) {

        try {

            // Writing patient details to file
            FileWriter writer = new FileWriter("patient.txt");

            writer.write("Patient ID: 201\n");
            writer.write("Patient Name: Rahul\n");
            writer.write("Age: 25\n");
            writer.write("Diagnosis: Fever\n");

            writer.close();

            System.out.println("Patient details written successfully.");

            // Reading patient details from file
            FileReader reader = new FileReader("patient.txt");

            int ch;

            System.out.println("\nPatient Details:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}