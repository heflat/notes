package com.heflat.notes.repository;

import com.heflat.notes.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 10:01
 */
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}