import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import static java.lang.System.out;

/**
 *
 * @author magnus
 */
public class Client {
        Socket socket = null;

        public Client connect() {
            String ip = (String) JOptionPane.showInputDialog(null, "IP?", "Connect to..", JOptionPane.QUESTION_MESSAGE);
            int port = Integer.parseInt(JOptionPane.showInputDialog(null, "Port?", "Connect to..", JOptionPane.QUESTION_MESSAGE));

            // try socket, if socket false close program
            try {
                socket = new Socket(ip, port);
            } catch (Exception e) {
                System.out.println("Client failed to connect");
                System.exit(0);
            }
            return null;
        }

        // send messages to server
        public Client chat() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean run = true;

            // if boolean run = true, write to server
            if (run) {
                out.println(JOptionPane.showInputDialog(null, "Name?", "Identify yourself!"));

                String msg = in.readLine();
                JOptionPane.showMessageDialog(null, msg, "Server said", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Client failed to communicate");
        }
            return null;
        }

        // close program
        public void close() throws Exception{
            out.close();
            socket.close();
            System.out.println("Done!");
    }
}