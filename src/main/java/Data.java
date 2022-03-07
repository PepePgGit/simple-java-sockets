import java.util.Date;

public class Data
{
    public Date receiveDate;
    public String buffor;

    Data(Date date, String buff)
    {
        this.receiveDate = date;
        this.buffor = buff;
    }

    @Override
    public String toString()
    {
        return DataFormatter.format(receiveDate) + " " + buffor;
    }
}
