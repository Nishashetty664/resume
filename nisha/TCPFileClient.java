import java.io.*;
import java.net.*;

public class TCPFileClient {

    public static void main(String[] args) throws Exception {
        String filename;

        // Reading input from the user
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        // Connecting to the server
        Socket clientSocket = new Socket("127.0.0.1", 6786);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        System.out.println("Connected to server");

        System.out.println("Enter the file name to download:");
        filename = inFromUser.readLine();

        // Sending filename to the server
        outToServer.writeBytes(filename + '\n');

        // Receiving file contents
        byte[] contents = new byte[10000];
        FileOutputStream fos = new FileOutputStream("Received_" + filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = clientSocket.getInputStream();

        int bytesRead;
        while ((bytesRead = is.read(contents)) != -1) {
            bos.write(contents, 0, bytesRead);
        }

        bos.flush();
        System.out.println("File saved successfully");

        // Closing connections
        clientSocket.close();
    }
}