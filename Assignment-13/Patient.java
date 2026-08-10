import java.io.*;

public class Patient {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("patient.txt");

        fw.write("Patient ID: 201\n");
        fw.write("Name: Rahul\n");
        fw.write("Age: 25\n");
        fw.write("Diagnosis: Fever\n");

        fw.close();

        FileReader fr = new FileReader("patient.txt");
        int ch;

        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }

        fr.close();
    }
}