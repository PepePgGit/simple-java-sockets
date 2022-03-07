import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable
{
    private int userName;
    private Date sendDate;
    private String content;

    Message(int userN, Date sendD, String cont)
    {
        this.userName = userN;
        this.sendDate = sendD;
        this.content = cont;
    }

    @Override
    public String toString()
    {
        return userName + ":" + " " + DataFormatter.format(sendDate) + " " + content;
    }
}
