package com.heflat.notes.util;

import com.heflat.notes.common.Constant;

import java.security.MessageDigest;

/**
 * Md5 加密工具类
 *
 * @author heflat
 * @date 2018-10-23 11:13
 */
public class Md5Util {

    private static final String SALT = "heflat!@#$%^&*()_++_))SDJKjdfk.";

    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    private static String md5Encode(String origin, String charsetName) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetName == null || "".equals(charsetName)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetName)));
            }
        } catch (Exception exception) {
        }
        return resultString.toUpperCase();
    }

    public static String md5Encode(String origin) {
        return md5Encode(origin + SALT, Constant.CHARACTER_DEFAULT);
    }
}