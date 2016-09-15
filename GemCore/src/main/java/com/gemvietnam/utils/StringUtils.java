package com.gemvietnam.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * String Utils
 * Created by neo on 2/16/2016.
 */
public class StringUtils {
    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean isEmpty(CharSequence s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNumeric(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static void openLink(Context context, String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        context.startActivity(i);
    }
}
