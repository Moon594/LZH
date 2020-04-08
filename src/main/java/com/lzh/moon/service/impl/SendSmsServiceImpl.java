package com.lzh.moon.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.lzh.moon.Config.sms.ALiYunConfig;
import com.lzh.moon.service.ISendSmsService;
import com.lzh.moon.utils.CodeUtil;
import com.lzh.moon.utils.VerificationUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GideonYeung
 */
@Service
public class SendSmsServiceImpl implements ISendSmsService {

    @Override
    public Map<String, Object> sendSms(String phone) {
        Map<String, Object> map = new HashMap<>();
        String code = CodeUtil.getMsgCode();
        try {
            if (VerificationUtil.isMobileNO(phone)) {
                map.put("code", 500);
                map.put("msg", "请输入正确的手机号码。");
                return map;
            }
            SendSmsResponse sendSmsResponse = ALiYunConfig.sendSms(phone, code);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {

                map.put("code", 200);
                map.put("msg", "短信发送成功。");
            } else {
                map.put("code", 301);
                map.put("msg", sendSmsResponse.getMessage());
            }

        } catch (ClientException e) {
            map.put("code", 500);
            map.put("msg", "短信发送失败。");
        }
        return map;
    }
}
