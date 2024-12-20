import java.io.*;
import java.net.*;

class TCPFileServer {

    public static void main(String[] args) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6786);

        System.out.println("Server is running and waiting for connection...");
        Socket connectionSocket = welcomeSocket.accept();
        System.out.println("Client connected");

        // Reading filename from client
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        String clientFile = inFromClient.readLine();
        System.out.println("Requested file: " + clientFile);

        // Check if the file exists
        File file = new File(clientFile);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            OutputStream os = connectionSocket.getOutputStream();

            byte[] contents = new byte[10000];
            int bytesRead;
            while ((bytesRead = bis.read(contents)) != -1) {
                os.write(contents, 0, bytesRead);
            }

            System.out.println("File sent successfully");
        } else {
            System.out.println("File not found: " + clientFile);
        }

        // Closing connections
        connectionSocket.close();
        welcomeSocket.close();
    }
}