import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author magnus
 */
public class Client {
        Socket socket = null;

        public class connect() {
            String ip = (String) JOptionPane.showInputDialog(null, "IP?", "Connect to..", JOptionPane.QUESTION_MESSAGE);
            int port = Integer.parseInt(JOptionPane.showInputDialog(null, "Port?", "Connect to..", JOptionPane.QUESTION_MESSAGE));

            // if socket fel stäng
            try {
                socket = new Socket(ip, port);
            } catch (Exception e) {
                System.out.println("Client failed to connect");
                System.exit(0);
            }
        }

        public class name(String msg) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean run = true;
            if (run) {
                out.println(JOptionPane.showInputDialog(null, "Name?", "Identify yourself!"));

                String msg = in.readLine();
                JOptionPane.showMessageDialog(null, msg, "Server said", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Client failed to communicate");
        }
    }
        public class close() throws Exception{
            out.close();
            socket.close();
            System.out.println("Done!");
    }
}