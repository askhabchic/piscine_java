import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;
//    private final static int port = 8080;

    public static void main(String[] args) {
        if (!args[0].startsWith("--server-port="))
            System.err.println("Invalid argument");
        int port = Integer.parseInt(args[0].substring(args[0].indexOf("=") + 1));
        if (port <= 1024 || port > 60000)
            System.err.println("Invalid port");
        try {
            clientSocket = new Socket("127.0.0.1", port);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String input = in.readLine();
            System.out.println(input);
            String cmd = reader.readLine();
            out.write(cmd + "\n");
            out.flush();

            String servMsg = in.readLine();
            System.out.println(servMsg);
            servMsg = reader.readLine();
            out.write(servMsg + "\n");
            out.flush();

            servMsg = in.readLine();
            System.out.println(servMsg);
            input = reader.readLine();
            out.write(input + "\n");
            out.flush();

            servMsg = in.readLine();
            System.out.println(servMsg);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
