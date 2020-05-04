import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private GameServer gameServer = null;
    public ClientThread(Socket socket, GameServer gameServer) {
        this.socket = socket;
        this.gameServer = gameServer;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (!request.equals("stop") && !request.equals("exit")) {
                String response = "Hello " + request + "!";
                out.println(response);
                out.flush();
                request = in.readLine();
                System.out.println("Server received the request.");
            }
            if(request.equals("exit")) {
                System.out.println("Client closed connection");
            }
            else {
                this.socket.close();
                gameServer.serverSocket.close();
                gameServer.isRunning = false;
                gameServer.x = 4;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}