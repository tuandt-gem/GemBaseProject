package com.gemvietnam.hocvalam.socialNetwork.util;

import com.gemvietnam.hocvalam.socialNetwork.R;

import android.content.Context;

import java.util.Calendar;

/**
 * Date/Time Utils
 * Created by neo on 7/20/2016.
 */
public class DateTimeUtils {

    /**
     * Return formatted date with default formatter
     */
    public static String formatDate(Context context, long dateTimeMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateTimeMillis);

        String format = context.getString(R.string.default_date_time_format);

        return String.format(format,
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE));
    }

    /**
     * Return formatted date without time
     */
    public static String formatDateWithoutTime(Context context, long dateTimeMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateTimeMillis);

        String format = context.getString(R.string.date_format_without_time);

        return String.format(format,
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.YEAR));
    }

    /**
     * Return formatted date without time
     */
    public static String formatDateSecondWithoutTime(Context context, long dateTimeSec) {
       return formatDateWithoutTime(context, dateTimeSec * 1000);
    }

    public static String formatDateSecondTime(Context context, long dateTimeSec) {
        return formatDate(context, dateTimeSec * 1000);
    }



}
