package com.danielleonett.androidbase.util;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author daniel.leonett
 */

public class CryptUtils {

    public static String toMd5(String string) {
        if (string == null) {
            return null;
        }

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(string.getBytes(Charset.forName("US-ASCII")), 0, string.length());
            byte[] magnitude = digest.digest();
            BigInteger bigInteger = new BigInteger(1, magnitude);
            return String.format("%0" + (magnitude.length << 1) + "x", bigInteger);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
