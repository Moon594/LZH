package com.lzh.moon.Contrlloer;

import com.lzh.moon.Vo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 用户进入首页的控制层
 *
 * @author LiAnGzh
 * @date 2020/4/8 10:57
 */
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("user");
        if (user!=null){
            model.addAttribute("user",user);
            return "home";
        }
        model.addAttribute("msg","请先登录哟!");
        return "login";
    }

}
