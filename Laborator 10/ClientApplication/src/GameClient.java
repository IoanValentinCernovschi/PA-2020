import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            while (!request.equals("exit") && !request.equals("stop")) {
                out.println(request);
                String response = in.readLine();
                System.out.println(response);
                request = scanner.nextLine();
            }
            if(request.equals("exit")) {
                out.println("exit");
            }
            else {
                out.println("stop");
            }

        } catch (UnknownHostException e) {
            System.err.println("No server ... " + e);
        }
    }
}
