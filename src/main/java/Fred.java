import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

@Setter
@Getter
public class Fred implements Runnable
{
    private Socket socket;
    private int user;

    Fred(Socket socket)
    {
        this.socket = socket;
    }

    @SneakyThrows
    @Override
    public void run()
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String message;
        while(!Thread.interrupted())
        {
            message = in.readLine();
            if(!message.equals("end"))
            {
                Data value = new Data(new Date(), message); // new
                message = message.split(":")[0];
                setUser(Integer.parseInt(message));
                System.out.println("Client " + this.user + " is connected");

                System.out.println(value);
                out.println(message);
            }
            else
            {
                socket.close();
                break;
            }
        }
        Thread.sleep(10000);
        System.out.println("Client " + this.user + " has disconnected");
    }
}

