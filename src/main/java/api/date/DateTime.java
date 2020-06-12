package api.date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author Albertino Augusto
 */
public class DateTime
{

    private int day;
    private int year;
    private int month;

    private int hour;
    private int mins;
    private int secs;
    private int am_pm;

    private final Calendar calendar;

    public DateTime()
    {
        calendar = new GregorianCalendar();

        this.hour = calendar.get(Calendar.HOUR);
        this.mins = calendar.get(Calendar.MINUTE);
        this.secs = calendar.get(Calendar.SECOND);
        this.am_pm = calendar.get(Calendar.AM_PM);

        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.year = calendar.get(Calendar.YEAR);

    }

    public String getOnlyHour()
    {
        String day_night;

        if (am_pm == 0)
        {
            day_night = "AM";
        }
        else
        {
            day_night = "PM";
        }

        if (hour == 0)
        {
            hour = 12;
        }

        if (day_night.equals("PM"))
        {
            switch (hour)
            {
                case 0:
                    hour = 12;
                    break;
                case 1:
                    hour = 13;
                    break;
                case 2:
                    hour = 14;
                    break;
                case 3:
                    hour = 15;
                    break;
                case 4:
                    hour = 16;
                    break;
                case 5:
                    hour = 17;
                    break;
                case 6:
                    hour = 18;
                    break;
                case 7:
                    hour = 19;
                    break;
                case 8:
                    hour = 20;
                    break;
                case 9:
                    hour = 21;
                    break;
                case 10:
                    hour = 22;
                    break;
                case 11:
                    hour = 23;
                    break;
            }
        }
        
        return hour + "";
    }

    public String getTime()
    {
        String day_night;

        if (am_pm == 0)
        {
            day_night = "AM";
        }
        else
        {
            day_night = "PM";
        }

        if (hour == 0)
        {
            hour = 12;
        }

        String h;
        if (hour < 10)
        {
            h = "0" + hour;
        }
        else
        {
            h = hour + "";
        }
        
        String m;
        if (mins < 10)
        {
            m = "0" + mins;
        }
        else
        {
            m = mins + "";
        }
        
        String s;
        if (secs < 10)
        {
            s = "0" + secs;
        }
        else
        {
            s = secs + "";
        }
        
        return h + ":" + m + ":" + s + " " + day_night;
    }
    
    
    public String getTimeWithSeconds()
    {
        String day_night;

        if (am_pm == 0)
        {
            day_night = "AM";
        }
        else
        {
            day_night = "PM";
        }

        if (hour == 0)
        {
            hour = 12;
        }

        
        String h;
        if (hour < 10)
        {
            h = "0" + hour;
        }
        else
        {
            h = hour + "";
        }
        
        String m;
        if (mins < 10)
        {
            m = "0" + mins;
        }
        else
        {
            m = mins + "";
        }
        
        
        String s;
        if (secs < 10)
        {
            s = "0" + secs;
        }
        else
        {
            s = secs + "";
        }
        
        return h + ":" + m + ":" + s + " " + day_night;
    }
    
    
    
    public String getTimeWithMinutes()
    {
        String day_night;

        if (am_pm == 0)
        {
            day_night = "AM";
        }
        else
        {
            day_night = "PM";
        }

        if (hour == 0)
        {
            hour = 12;
        }

        
        String h = "";
        if (hour < 10)
        {
            h = "0" + hour;
        }
        else
        {
            h = hour + "";
        }
        
        String m = "";
        if (mins < 10)
        {
            m = "0" + mins;
        }
        else
        {
            m = mins + "";
        }
        
        return h + ":" + m + " " + day_night;
    }
    
    

    public String translateToSlashedDate(String dashedDate)
    {
        String date = "";

        try
        {
            date = dashedDate.split("-")[0] + "/" + dashedDate.split("-")[1] + "/" + dashedDate.split("-")[2];
        }
        catch (Exception e)
        {

        }

        return date;
    }

    public String getTimetype()
    {
        String day_night;

        if (am_pm == 0)
        {
            day_night = "AM";
        }
        else
        {
            day_night = "PM";
        }

        return day_night;
    }

    public String getFullDateDash()
    {
        String fullDate = "";

        String d = "";
        if (this.day < 10)
        {
            d = "0" + this.day;
        }
        else
        {
            d = this.day + "";
        }

        String m = "";
        if (this.month < 10)
        {
            m = "0" + this.month;
        }
        else
        {
            m = this.month + "";
        }

        fullDate = d + "-" + m + "-" + this.year + " - " + this.getTime();

        return fullDate;
    }

    public String getFullDateSlash()
    {
        String fullDate = "";

        String d = "";
        if (this.day < 10)
        {
            d = "0" + this.day;
        }
        else
        {
            d = this.day + "";
        }

        String m = "";
        if (this.month < 10)
        {
            m = "0" + this.month;
        }
        else
        {
            m = this.month + "";
        }

        fullDate = d + "/" + m + "/" + this.year + " - " + this.getTime();

        return fullDate;
    }

    public String getDateSlash()
    {
        String fullDate = "";

        String d = "";
        if (this.day < 10)
        {
            d = "0" + this.day;
        }
        else
        {
            d = this.day + "";
        }

        String m = "";
        if (this.month < 10)
        {
            m = "0" + this.month;
        }
        else
        {
            m = this.month + "";
        }

        fullDate = d + "/" + m + "/" + this.year;

        return fullDate;
    }

    public String getDateDash()
    {
        String fullDate = "";

        String d = "";
        if (this.day < 10)
        {
            d = "0" + this.day;
        }
        else
        {
            d = this.day + "";
        }

        String m = "";
        if (this.month < 10)
        {
            m = "0" + this.month;
        }
        else
        {
            m = this.month + "";
        }

        fullDate = d + "-" + m + "-" + this.year;

        return fullDate;
    }

    public int getHour()
    {
        return hour;
    }

    public String getDay(int day)
    {
        String d = "";
        if (day < 10)
        {
            d = "0" + day;
        }
        else
        {
            d = day + "";
        }

        return d;
    }

    public int getDayInt()
    {
        return this.day;
    }

    public String getDay()
    {
        String d = "";
        if (this.day < 10)
        {
            d = "0" + this.day;
        }
        else
        {
            d = this.day + "";
        }

        return d;
    }

    public int getMonthInt()
    {
        return this.month;
    }

    public String getMonth(int month)
    {
        String m = "";
        if (month < 10)
        {
            m = "0" + month;
        }
        else
        {
            m = month + "";
        }

        return m;
    }

    public String getMonth()
    {
        String m = "";
        if (this.month < 10)
        {
            m = "0" + this.month;
        }
        else
        {
            m = this.month + "";
        }

        return m;
    }

    public int getYear()
    {
        return year;
    }

    public String getDate()
    {
        String d;
        if (day < 10)
        {
            d = "0" + day;
        }
        else
        {
            d = day + "";
        }

        String m;
        if (month < 10)
        {
            m = "0" + month;
        }
        else
        {
            m = month + "";
        }

        return d + "-" + m + "-" + year;
    }

    
    
    public String translateToLiteralMonth(int month)
    {
        String m = "";

        if (month == 1)
        {
            m = "Janeiro";
        }
        else if (month == 2)
        {
            m = "Fevereiro";
        }
        else if (month == 3)
        {
            m = "Março";
        }
        else if (month == 4)
        {
            m = "Abril";
        }
        else if (month == 5)
        {
            m = "Maio";
        }
        else if (month == 6)
        {
            m = "Junho";
        }
        else if (month == 7)
        {
            m = "Julho";
        }
        else if (month == 8)
        {
            m = "Agosto";
        }
        else if (month == 9)
        {
            m = "Setembro";
        }
        else if (month == 10)
        {
            m = "Outubro";
        }
        else if (month == 11)
        {
            m = "Novembro";
        }
        else if (month == 12)
        {
            m = "Dezembro";
        }

        return m;
    }
    
    
    
    public String translateToLiteralMonth(String month)
    {
        String m = "";

        if (month.equals("01"))
        {
            m = "Jan";
        }
        else if (month.equals("02"))
        {
            m = "Fev";
        }
        else if (month.equals("03"))
        {
            m = "Mar";
        }
        else if (month.equals("04"))
        {
            m = "Abr";
        }
        else if (month.equals("05"))
        {
            m = "Mai";
        }
        else if (month.equals("06"))
        {
            m = "Jun";
        }
        else if (month.equals("07"))
        {
            m = "Jul";
        }
        else if (month.equals("08"))
        {
            m = "Ago";
        }
        else if (month.equals("09"))
        {
            m = "Set";
        }
        else if (month.equals("10"))
        {
            m = "Out";
        }
        else if (month.equals("11"))
        {
            m = "Nov";
        }
        else if (month.equals("12"))
        {
            m = "Dez";
        }

        return m;
    }

    
    
    public String getToDay()
    {
        String m = "";

        if (month == 0)
        {
            m = "Jan";
        }
        else if (month == 1)
        {
            m = "Fev";
        }
        else if (month == 2)
        {
            m = "Mar";
        }
        else if (month == 3)
        {
            m = "Abr";
        }
        else if (month == 4)
        {
            m = "Mai";
        }
        else if (month == 5)
        {
            m = "Jun";
        }
        else if (month == 6)
        {
            m = "Jul";
        }
        else if (month == 7)
        {
            m = "Ago";
        }
        else if (month == 8)
        {
            m = "Set";
        }
        else if (month == 9)
        {
            m = "Out";
        }
        else if (month == 10)
        {
            m = "Nov";
        }
        else if (month == 11)
        {
            m = "Dez";
        }

        return day + "-" + m + "-" + year;
    }

    public void setTimeToThis(final JLabel label)
    {
        final int timeRun = 0;

        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    while (timeRun == 0)
                    {
                        Calendar calendar = new GregorianCalendar();
                        int hour = calendar.get(Calendar.HOUR);
                        int min = calendar.get(Calendar.MINUTE);
                        int sec = calendar.get(Calendar.SECOND);
                        int am_pn = calendar.get(Calendar.AM_PM);

                        String day_night;

                        if (am_pn == 0)
                        {
                            day_night = "AM";
                        }
                        else
                        {
                            day_night = "PM";
                        }

                        if (hour == 0)
                        {
                            hour = 12;
                        }

                        String time = hour + ":" + min + ":" + sec + " " + day_night;
                        label.setText(time);
                    }
                }
                catch (Exception e)
                {

                }
            }
        }.start();
    }

}
