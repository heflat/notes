package com.heflat.notes.util;

import java.util.UUID;

/**
 * 生成器工具类
 *
 * @author heflat
 * @date 2018-10-23 10:54
 */
public class GenerateUtil {

    public static String uniqueKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}