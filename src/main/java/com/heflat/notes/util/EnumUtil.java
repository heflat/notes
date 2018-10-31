package com.heflat.notes.util;

import com.heflat.notes.enums.CodeEnum;

/**
 * 枚举工具类
 *
 * @author heflat
 * @date 2018-10-23 13:50
 */
public class EnumUtil {

    /**
     * 通过 code 获取枚举对象
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T t : enumClass.getEnumConstants()) {
            if (code.equals(t.getCode())) {
                return t;
            }
        }

        return null;
    }
}