package vasili.echoserver.whileserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        final Logger log = LoggerFactory.getLogger("Server");

        try (var server = new ServerSocket(4444);
             var client = server.accept();
             var in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             var out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
            log.info("Server started");
            while (!client.isClosed()) {
                String message = in.readLine();
                if (message.equals("Buy")) {
                    out.write("Buy!!! Have a nice day!!");
                    out.flush();
                    break;
                }
                out.write("Your message : " + message + "\n");
                out.flush();
            }
            log.info("Server closed");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
