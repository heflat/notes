package com.heflat.notes.service;

import com.heflat.notes.NotesApplicationTests;
import com.heflat.notes.pojo.User;
import com.heflat.notes.util.GenerateUtil;
import com.heflat.notes.util.Md5Util;
import com.heflat.notes.vo.ResultVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 11:11
 */
public class UserServiceTest extends NotesApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setUserId(GenerateUtil.uniqueKey());
        user.setUsername("heflat");
        user.setPassword(Md5Util.md5Encode("123456"));
        user.setEmail("h@heflat.com");
        ResultVO resultVO = userService.register(user);

        Assert.assertTrue(resultVO.getData() != null);
    }

    @Test
    public void login() {
        User user = userService.login("heflat", "123456");

        Assert.assertTrue(user != null);
    }

    @Test
    public void checkUsername() {
        User user = userService.checkUsername("heflat");

        Assert.assertTrue(user != null);
    }
}