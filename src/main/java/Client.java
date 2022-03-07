import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("New Client");
            Socket socket = new Socket("Localhost",8081);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            System.out.println("User: ");
            int user = Integer.parseInt(scanner.nextLine());

            while(true)
            {
                System.out.println("Message: ");
                String content = scanner.nextLine();

                Message message = new Message(user, new Date(), content);
                out.println(message);

                String answer = in.readLine();
                System.out.println("Message successfully sent user: " + answer);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
