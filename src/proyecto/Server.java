package proyecto;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {



        int portNumber = 1234;

        try (
                ServerSocket serverSocket =new ServerSocket(portNumber);

                Socket clientSocket = serverSocket.accept();
                PrintWriter out =new PrintWriter(clientSocket.getOutputStream(), true);

                BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));

        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                inputLine=inputLine.toUpperCase();
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Error en el puerto "+ portNumber);

            System.out.println(e.getMessage());
        }
    }
}
