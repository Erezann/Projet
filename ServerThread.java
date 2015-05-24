import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ServerThread extends Thread {
    private Socket clientSocket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private static final String ERREUR = "ERROR";

    private String CLIENT_IN = "One new client " + this.getName()
            + " comes in...";
    private String CLIENT_SAY = "Client " + this.getName() + " says: ";
    private String CLIENT_BYE = "Bye, " + this.getName();
    private String CLIENT_EXIT = this.getName() + " exit...";
    private static final String STOP = "stop";

    public ServerThread(Socket socket) throws IOException {
        super("MultiServerThread");
        this.clientSocket = socket;
        bufferedReader = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream())); // read the input of the
        // client
        printWriter = new PrintWriter(clientSocket.getOutputStream(), true); // write
        // to
        // the
        // client
        System.out.println(CLIENT_IN);
        start();
    }

    public void run() {
        try {
            String in = null;
            in = bufferedReader.readLine();
            while (in!=null && !in.equalsIgnoreCase(STOP) ) {
                System.out.println(CLIENT_SAY + in);
                // client
                printWriter.flush();
                in = bufferedReader.readLine();
            }
            // printWriter.println(CLIENT_BYE);
            System.out.println(CLIENT_EXIT);
            printWriter.close();
            bufferedReader.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println(ERREUR);
        }
    }
}