/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZHU Yuting
 * 
 */
public class MultiServer {
    private static final int port = 9874;
    private ServerSocket serverSocket = null;

    private static final String CONNECT = "connected...";
    private static final String ERREUR = "ERROR";

    public MultiServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println(CONNECT);
    }

    public void server() throws IOException {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ServerThread(clientSocket);
            }
        } catch (IOException e) {
            System.err.println(ERREUR);
        } finally {
            serverSocket.close();
        }
    }
}
