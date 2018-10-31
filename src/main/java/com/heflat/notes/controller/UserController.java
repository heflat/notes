package com.heflat.notes.controller;

import com.heflat.notes.common.Constant;
import com.heflat.notes.common.form.UserForm;
import com.heflat.notes.enums.NotesEnum;
import com.heflat.notes.pojo.User;
import com.heflat.notes.service.UserService;
import com.heflat.notes.util.ResultVOUtil;
import com.heflat.notes.vo.ResultVO;
import com.heflat.notes.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.stream.Collectors;

/**
 * 用户
 *
 * @author heflat
 * @date 2018-10-23 11:19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param session
     * @param userForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public ResultVO register(HttpSession session,
                             @Valid UserForm userForm,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(NotesEnum.USER_PARAM_ERROR,
                    bindingResult.getAllErrors().stream()
                            .map(message -> message.getDefaultMessage())
                            .collect(Collectors.toList()));
        }

        User user = new User();
        BeanUtils.copyProperties(userForm, user);

        ResultVO resultVO = userService.register(user);
        if (resultVO.isSuccess()) {
            session.setAttribute(Constant.CURRENT_USER, resultVO.getData());
        }

        return resultVO;
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        User user = userService.login(username, password);
        if (user != null) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            return ResultVOUtil.success(userVO);
        }
        return ResultVOUtil.error();
    }
}