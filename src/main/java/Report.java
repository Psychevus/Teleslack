import java.util.Date;

import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.util.Calendar;

/**
 * Created by Mojtaba on 7/11/2016.
 */
public class Report {


    public static String date() {

        System.out.println("Create a PersianCalendar object with current date and time of system:");
        PersianCalendar persianCalendar1 = new PersianCalendar(new Date());

        int y = persianCalendar1.get(Calendar.YEAR);
        int m = (persianCalendar1.get(Calendar.MONTH) + 1);
        int d = persianCalendar1.get(Calendar.DAY_OF_MONTH);
        int d_week = persianCalendar1.get(Calendar.DAY_OF_WEEK);
        System.out.println(d_week);
        String day = null;
        if (d_week == 0) {
            day = "شنبه";
        } else if (d_week == 1) {
            day = "یک شنبه";
        } else if (d_week == 2) {
            day = "دو شنبه";
        } else if (d_week == 3) {
            day = "سه شنبه";
        } else if (d_week == 4) {
            day = "چهار شنبه";
        } else if (d_week == 5) {
            day = "پنج شنبه";
        } else if (d_week == 6) {
            day = "جمعه";
        }


        String date = day + " "
                + y + "/"
                + m + "/"
                + d;


        char[] arabicChars = {'۰','۱','۲','۳','۴','۵','۶','۷','۸','۹'};
        StringBuilder builder = new StringBuilder();
        for(int i =0;i<date.length();i++)
        {
            if(Character.isDigit(date.charAt(i)))
            {
                builder.append(arabicChars[(int)(date.charAt(i))-48]);
            }
            else
            {
                builder.append(date.charAt(i));
            }
        }

        return builder.toString();
    }

}
