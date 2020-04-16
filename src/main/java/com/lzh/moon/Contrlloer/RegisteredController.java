package com.lzh.moon.Contrlloer;

import com.lzh.moon.Vo.Users;
import com.lzh.moon.common.DefaultResult;
import com.lzh.moon.common.DefaultResultData;
import com.lzh.moon.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 注册
 *
 * @author LiAnGzh
 * @date 2020/3/20 22:43
 */
@Controller
public class RegisteredController {

    @Autowired
    private RegisteredService registeredService;

    public RegisteredController(RegisteredService registeredService) {
        this.registeredService = registeredService;
    }

    @GetMapping("/registered")
    public String registered(){
        return "registered";
    }

    @PostMapping("/registered")
    @ResponseBody
    public DefaultResult registered(Users user, @Param("code")String code){
        DefaultResult defaultResult = registeredService.insertUser(user, code);
        System.out.println(defaultResult.getCode());
        System.out.println(defaultResult.getMessage());
        return defaultResult;
    }
}
