
import java.net.*;
import java.io.*;

public class TCPServer {

    public static void main(String args[]) {
        Socket clientSocket = null;
        try {
            int serverPort = 7777; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            clientSocket = listenSocket.accept();
            BufferedReader in;
            PrintWriter out;

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));

            while (true) {
                String data = in.readLine();
                System.out.println("Echoing: " + data);
                String fileLocation = data.split(" ")[1];
                BufferedReader br = new BufferedReader (new FileReader("." + fileLocation));
                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    out.println(currentLine);
                }
                out.println(data);
                out.flush();
            }

        } catch (IOException e) {
            System.out.println("IO Exception:" + e.getMessage());
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                // ignore exception on close
            }
        }
    }
}