import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;
    public ServerSocket serverSocket = null;
    public boolean isRunning = true;
    public int x = 3;
    public GameServer() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            while(isRunning) {
                System.out.println("Waiting for clients to connect...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket, this).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Server stopped");
        }
    }
    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }
}