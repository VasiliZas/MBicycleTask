package vasili.echoserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

public class MyServer {

    public static void main(String[] args) {
        final Logger log = LoggerFactory.getLogger("Server");

        try (var server = new ServerSocket(4444);
             var client = server.accept();
             var in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             var out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
            log.info("Server started");
            String message = in.readLine();
            out.write("Hi!! I'm your server. Your message : " + message + "\n");
            out.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            log.info("Server closed");
        }
    }
}
