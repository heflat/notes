package com.heflat.notes.common.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 11:24
 */
@Getter
@Setter
public class UserForm {

    private String userId;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private Integer gender = 2;

    private Integer age;

    private String phone;

    @NotBlank(message = "邮箱不能为空")
    private String email;

    private String avatar;

    private String description;
}