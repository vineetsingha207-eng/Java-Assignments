import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5001);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(
            new InputStreamReader(System.in));

        System.out.print("enter message: ");
        String msg = kb.readLine();

        out.println(msg);
        System.out.println("server response: " + in.readLine());

        s.close();
    }
}