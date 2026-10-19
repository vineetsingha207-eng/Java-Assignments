import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(
            new InputStreamReader(System.in));

        String msg;
        while (true) {
            System.out.print("client: ");
            msg = kb.readLine();
            out.println(msg);

            if (msg.equalsIgnoreCase("exit"))
                break;

            msg = in.readLine();
            System.out.println("server: " + msg);

            if (msg.equalsIgnoreCase("exit"))
                break;
        }

        s.close();
    }
}