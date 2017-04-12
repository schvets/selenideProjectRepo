package com.selenium.test.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Aleksandr on 06.04.2017.
 */
public class DayQualifier {
    public int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        --day;
        if (day == 0)
            day = 7;
        return day;
    }
}
