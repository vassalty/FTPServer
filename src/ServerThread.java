import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServerThread extends Thread {

    private Socket connectionSocket;

    public ServerThread(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    public void run() {
        try {
            while (true) {
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                String fromClient = null;
                try {
                    fromClient = inFromClient.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                StringTokenizer tokens = new StringTokenizer(fromClient);

                String frstln = tokens.nextToken();
                int port = Integer.parseInt(frstln);
                String clientCommand = tokens.nextToken();

                if (clientCommand.equals("list:")) {

                        Socket dataSocket = new Socket(connectionSocket.getInetAddress(), port);
                        DataOutputStream dataOutToClient = new DataOutputStream(dataSocket.getOutputStream());
                        //..........................

                        dataOutToClient.close();
                        dataSocket.close();
                        System.out.println("Data Socket closed");
                }

                //......................


                if(clientCommand.equals("retr:")) {
                    //..............................
                    //..............................
                }
            }
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
