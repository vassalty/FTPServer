import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.*;
import java.util.*;

class FTPServer {

    public static void main(String[] args) throws IOException {

        String fromClient;
        String clientCommand;
        byte[] data;

        ServerSocket welcomeSocket = new ServerSocket(12000);
        String frstln;

        while(true) {
            Socket connectionSocket = welcomeSocket.accept();

            ServerThread serverThread = new ServerThread(connectionSocket);

            serverThread.run();

        }
    }
}
    