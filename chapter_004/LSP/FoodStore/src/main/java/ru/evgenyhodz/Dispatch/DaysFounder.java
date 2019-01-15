package ru.evgenyhodz.Dispatch;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 30.12.2016
 */
public class DaysFounder {
    /**
     * Date formatter.
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * Method creates DateTime class for Joda Time API.
     *
     * @param date - date from anywhere.
     * @return - object DateTime.
     */
    private DateTime createDate(String date) {
        Date result = null;
        try {
            result = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new DateTime(result);
    }

    /**
     * Getter of current date.
     */
    private String getCurrentDate() {
        return LocalDate.now().toString().replaceAll("-", "/");
    }

    /**
     * Method to count days from one date to another.
     *
     * @param start - start date.
     * @param end   - end date.
     * @return - number of days.
     */
    public double numOfDays(String start, String end) {
        double result;
        int fullTerm = Days.daysBetween(createDate(start), createDate(end)).getDays();
        int expTerm = Days.daysBetween(createDate(start), createDate(getCurrentDate())).getDays();
        int daysToEnd = fullTerm - expTerm;
        if (daysToEnd > 0) {
            result = daysToEnd;
        } else {
            result = 0;
        }
        return result;
    }
}
