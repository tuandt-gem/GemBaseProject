package com.gemvietnam.utils;

import com.gemvietnam.common.R;

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
                cal.get(Calendar.MONTH),
                cal.get(Calendar.YEAR),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE));
    }

}
