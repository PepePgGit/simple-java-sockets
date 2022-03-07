import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatter
{
    public static String format(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
