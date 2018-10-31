package com.heflat.notes.service.impl;

import com.heflat.notes.enums.NotesEnum;
import com.heflat.notes.pojo.User;
import com.heflat.notes.repository.UserRepository;
import com.heflat.notes.service.UserService;
import com.heflat.notes.util.GenerateUtil;
import com.heflat.notes.util.Md5Util;
import com.heflat.notes.util.ResultVOUtil;
import com.heflat.notes.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 11:10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResultVO register(User user) {
        User checkUser = userRepository.findByUsername(user.getUsername());
        if (checkUser != null) {
            return ResultVOUtil.error(NotesEnum.USER_EXISTED);
        }

        user.setUserId(GenerateUtil.uniqueKey());
        String md5Password = Md5Util.md5Encode(user.getPassword());
        user.setPassword(md5Password);

        User result = userRepository.save(user);
        return ResultVOUtil.success(result);
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, Md5Util.md5Encode(password));
    }

    @Override
    public User checkUsername(String username) {
        return userRepository.findByUsername(username);
    }
}