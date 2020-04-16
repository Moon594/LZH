package com.lzh.moon.Contrlloer;

import com.lzh.moon.service.ISendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 短信发送控制器
 *
 * @author LiAnGzh
 * @date 2020/4/8 15:17
 */
@Controller
public class SendMsgController {

    @Autowired
    ISendSmsService sendSms;
    @PostMapping("/sendCode")
    @ResponseBody
    public Map<String, Object> sendSms(@Param("userTel")String userTel){
        return sendSms.sendSms(userTel);
    }
}
