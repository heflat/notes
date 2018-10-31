package com.heflat.notes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户性别
 *
 * @author heflat
 * @date 2018-10-23 13:47
 */
@Getter
@AllArgsConstructor
public enum UserGenderEnum implements CodeEnum {

    GIRL(0, "女"),
    BOY(1, "男"),
    UNKNOWN(2, "未填"),
    ;

    private Integer code;

    private String message;
}