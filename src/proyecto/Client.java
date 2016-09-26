package proyecto;
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args)throws  IOException {
        String hostIP = "127.0.0.1";
        int portNumber = 1234;

        try (
                Socket echoSocket = new Socket(hostIP, portNumber);
                PrintWriter out =new PrintWriter(echoSocket.getOutputStream(), true);

                BufferedReader in =new BufferedReader( new InputStreamReader(echoSocket.getInputStream()));


                BufferedReader stdIn =new BufferedReader(new InputStreamReader(System.in))

        )

        {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("No se conoce: " + hostIP);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se ha podido conectar : " +hostIP);

            System.exit(1);
        }
    }
}
