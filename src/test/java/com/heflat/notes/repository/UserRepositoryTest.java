package com.heflat.notes.repository;

import com.heflat.notes.NotesApplicationTests;
import com.heflat.notes.pojo.User;
import com.heflat.notes.util.GenerateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 10:05
 */
public class UserRepositoryTest extends NotesApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save() {
        User user = new User();
        user.setUserId(GenerateUtil.uniqueKey());
        user.setUsername("heflat");
        user.setPassword("123456");
        user.setEmail("h@heflat.com");
        User result = userRepository.save(user);

        Assert.assertTrue(result != null);
    }

    @Test
    public void findByUsernameAndPassword() {
        User result = userRepository.findByUsernameAndPassword("heflat", "123456");

        Assert.assertTrue(result != null);
    }

    @Test
    public void findByUsername() {
        User result = userRepository.findByUsername("heflat");

        Assert.assertTrue(result != null);
    }
}