package com.lzh.moon.Contrlloer;

import com.lzh.moon.service.ISendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

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
    @PostMapping("/sendSms")
    public Map<String, Object> sendSms(String userTel){
        return sendSms.sendSms(userTel);
    }
}
