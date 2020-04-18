package com.lzh.moon.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.lzh.moon.Vo.Users;
import com.lzh.moon.common.DefaultResult;
import com.lzh.moon.mapper.UsersMapper;
import com.lzh.moon.utils.AliSmsUtil;
import com.lzh.moon.service.ISendSmsService;
import com.lzh.moon.utils.CodeUtil;
import com.lzh.moon.utils.RedisUtil;
import com.lzh.moon.utils.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GideonYeung
 */
@Service
public class SendSmsServiceImpl implements ISendSmsService {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Map<String, Object> sendSms(String phone) {
        Map<String, Object> map = new HashMap<>();
        String code = CodeUtil.getMsgCode();
        try {
            //这里进入发短信,首先会判断你是不是手机号
            //是手机号我们就返回true 则相反
            if (!VerificationUtil.isMobileNO(phone)) {
                map.put("code", 302);
                map.put("msg", "请输入正确的手机号码。");
                return map;
            }
            //知道他是手机号之后,我们需要验证是否已经存在该用户
            List<Users> users = usersMapper.selectByUserTel(phone);
            if (users != null && users.size() > 0) {
                map.put("code", 301);
                map.put("msg", "该用户已存在");
                return map;
            }
            //开始发送短信
            SendSmsResponse sendSmsResponse = AliSmsUtil.sendSms(phone, code);
            //然后判断结果,返回给前端结果
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                //短信发送成功就把验证码存到redis中
                redisUtil.set(phone,code);
                map.put("code", 200);
                map.put("msg", "短信发送成功");
            } else {
                map.put("code", 302);
                map.put("msg", sendSmsResponse.getMessage());
            }

        } catch (ClientException e) {
            map.put("code", 500);
            map.put("msg", "短信发送失败。");
        }
        return map;
    }
}
