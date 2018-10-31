package com.heflat.notes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局 Code 状态码
 *
 * @author heflat
 * @date 2018-10-23 11:21
 */
@Getter
@AllArgsConstructor
public enum NotesEnum {

    SUCCESS(0, "成功"),
    ERROR(1, "失败"),

    USER_PARAM_ERROR(10, "参数错误"),
    USER_EXISTED(11, "用户名已存在"),
    ;

    private Integer code;

    private String message;
}