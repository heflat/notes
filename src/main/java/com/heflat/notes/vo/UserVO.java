package com.heflat.notes.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heflat.notes.enums.UserGenderEnum;
import com.heflat.notes.util.EnumUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 13:45
 */
@Getter
@Setter
public class UserVO {

    private String userId;

    private String username;

    private Integer gender;

    private Integer age;

    private String phone;

    private String email;

    private String avatar;

    private String description;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public UserGenderEnum getUserGenderEnum() {
        return EnumUtil.getByCode(this.gender, UserGenderEnum.class);
    }
}