package com.lzh.moon.Contrlloer;

import com.lzh.moon.Vo.Users;
import com.lzh.moon.common.DefaultResult;
import com.lzh.moon.common.DefaultResultData;
import com.lzh.moon.common.ResultCode;
import com.lzh.moon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户登录控制器
 *
 * @author LiAnGzh
 * @date 2020/4/7 16:02
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,Model model) {
        session.invalidate();
        model.addAttribute("msg","退出成功!");
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public DefaultResult login(String userTel, String userPassword, HttpSession session) {
        List<Users> user = loginService.selectByUser(userTel, userPassword);
        if (!user.isEmpty()) {
            session.setAttribute("user", user.get(0));
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);

    }
}
