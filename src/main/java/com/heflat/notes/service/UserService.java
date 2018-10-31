package com.heflat.notes.service;

import com.heflat.notes.pojo.User;
import com.heflat.notes.vo.ResultVO;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 11:09
 */
public interface UserService {

    /**
     * 注册
     * @param user
     * @return
     */
    ResultVO register(User user);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 校验用户名
     * @param username
     * @return
     */
    User checkUsername(String username);
}