import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class serverModel {
    ServerSocket serverSocket;
    Socket socket;
    int port = 1234;

    // run server
    public Socket runServer() throws IOException {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        return socket;
    }

    // wait for connection
    // change variable name???
    public void connectionListener() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Client connected!");
    }


}
