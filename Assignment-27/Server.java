import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("server started");

        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(
            new InputStreamReader(System.in));

        String msg;
        while (true) {
            msg = in.readLine();
            if (msg.equalsIgnoreCase("exit"))
                break;

            System.out.println("client: " + msg);
            System.out.print("server: ");
            msg = kb.readLine();
            out.println(msg);

            if (msg.equalsIgnoreCase("exit"))
                break;
        }

        s.close();
        ss.close();
    }
}