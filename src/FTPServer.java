import java.io.*;
import java.net.*;

class FTPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket welcomeSocket = new ServerSocket(12000);

        while(true) {
            Socket connectionSocket = welcomeSocket.accept();

            ServerThread serverThread = new ServerThread(connectionSocket);

            serverThread.run();

        }
    }
}
    