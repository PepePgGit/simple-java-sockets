import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Server
{
    private static Date receiveDate;

    public static void main(String[] args)
    {
        try
        {
            System.out.println("Waiting for client");
            ServerSocket serverSocket = new ServerSocket(8081);
            List<Thread> threads = new ArrayList<>();

            while(true)
            {
                Socket socket = serverSocket.accept();

                threads.add(new Thread(new Fred(socket)));
                threads.get(threads.size()-1).start();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
