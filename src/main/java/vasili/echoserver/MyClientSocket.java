package vasili.echoserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyClientSocket {

    public static void main(String[] args) {
        final Logger log = LoggerFactory.getLogger("Client");

        try (var client = new Socket("localhost", 4444);
             var reader = new BufferedReader(new InputStreamReader(System.in));
             var in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             var out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
            log.info("Write your message here : ");
            String message = reader.readLine();
            out.write(message + "\n");
            out.flush();
            String serverMessage = in.readLine();
            log.info(serverMessage);
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            log.info("Your connection closed ");
        }
    }
}
