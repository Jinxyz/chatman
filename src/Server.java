import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author magnus
 */

public class Server {
    public static void main(String[] args){
        int port = 1234;
        boolean run = true;
        ServerSocket serverSocket;
        Socket socket;
        System.out.println("Server started.");

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Waiting for connections!");
                socket = serverSocket.accept();
                // Go
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Client connected!");

                // läs vad client säger och printa
                String msg = in.readLine();
                    System.out.println(msg);
                    // kanske int ebehövs rad
                    System.out.println("hej jag läser");

                    // skriv meddelande och skicka
                    out.println("");

                    // close server
                    in.close();
                    out.close();
                    socket.close();
                    System.out.println("Closing down " + name);
                }
             }