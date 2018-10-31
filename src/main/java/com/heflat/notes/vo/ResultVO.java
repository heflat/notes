package com.heflat.notes.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heflat.notes.enums.NotesEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Json 返回视图
 *
 * @author heflat
 * @date 2018-10-23 11:20
 */
@Getter
@Setter
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;

    @JsonIgnore
    public boolean isSuccess() {
        return this.code.equals(NotesEnum.SUCCESS.getCode());
    }
}