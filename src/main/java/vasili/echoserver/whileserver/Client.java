package vasili.echoserver.whileserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        final Logger log = LoggerFactory.getLogger("Client");

        try (Socket client = new Socket("localhost", 4444);
             var reader = new BufferedReader(new InputStreamReader(System.in));
             var in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             var out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
            log.info("Write your message here : ");
            while (!client.isOutputShutdown()) {
                String message = reader.readLine();
                out.write(message + "\n");
                out.flush();
                if (message.equals("Buy")) {
                    String serverMessage = in.readLine();
                    log.info(serverMessage);
                    log.info("Your connection closed ");
                    break;
                }
                String serverMessage = in.readLine();
                log.info(serverMessage);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
