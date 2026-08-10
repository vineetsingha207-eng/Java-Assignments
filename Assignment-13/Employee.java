import java.io.*;

public class Employee {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("employee.txt");

        fw.write("Employee ID: 101\n");
        fw.write("Name: Vineet\n");
        fw.write("Department: IT\n");
        fw.write("Salary: 50000\n");

        fw.close();

        FileReader fr = new FileReader("employee.txt");
        int ch;

        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }

        fr.close();
    }
}