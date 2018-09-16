package com.danielleonett.androidbase.util;

import android.content.Context;
import android.os.Vibrator;

public class VibrationUtils {

    public static void vibrate(Context context, int milliseconds) {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(milliseconds);
    }

}
