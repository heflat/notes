package com.heflat.notes.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 9:57
 */
@Entity
@DynamicUpdate
@Getter
@Setter
@ToString
public class User {

    /** id */
    @Id
    private String userId;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 性别 */
    private Integer gender;

    /** 年龄 */
    private Integer age;

    /** 手机号 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 头像 */
    private String avatar;

    /** 描述 */
    private String description;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;
}