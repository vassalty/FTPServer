import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.*;
import java.util.*;

class FTPServer {

    public static void main(String[] args) {

        try {
            ServerSocket welcomeSocket = new ServerSocket(12000);

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                ServerThread serverThread = new ServerThread(connectionSocket);

                serverThread.run();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    