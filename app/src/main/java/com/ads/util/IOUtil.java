package com.ads.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by bah on 9/21/15.
 */
public class IOUtil {
    public static String toString(InputStream inputStream) {

        if (inputStream == null) return null;

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        // Outer try block for exceptions.
        try {
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;

            // Inner try block for streams that need closing.
            try {
                inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                bufferedReader = new BufferedReader(inputStreamReader);

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            } finally {

                if (bufferedReader != null) bufferedReader.close();
                if (inputStream != null) inputStream.close();
            }
        } catch (Throwable throwable) {
            Log.e("IOUtility", "Unable to convert the InputStream to a String.");
        }

        return stringBuilder.toString();
    }
}
