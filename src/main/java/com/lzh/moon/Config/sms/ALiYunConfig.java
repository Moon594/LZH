package com.lzh.moon.Config.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lzh.moon.Config.properties.ApplicationConfig;
import com.lzh.moon.constant.ALiYunConstants;
/**
 * 发送短信
 *
 * @author GideonYeung
 */
public class ALiYunConfig {
    /* 短信发送 */
    public static SendSmsResponse sendSms(String phone,String code) throws ClientException {

        /* 超时时间，可自主调整 */
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        /* 初始化acsClient,暂不支持region化 */
        IClientProfile profile = DefaultProfile.getProfile(ALiYunConstants.REGIONLD, ApplicationConfig.getAccessKeyId(), ApplicationConfig.getAccessKeySecret());
        DefaultProfile.addEndpoint(ALiYunConstants.REGIONLD, ALiYunConstants.REGIONLD, ALiYunConstants.PRODUCT, ALiYunConstants.DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        /* 组装请求对象-具体描述见控制台-文档部分内容 */
        SendSmsRequest request = new SendSmsRequest();
        /* 必填:待发送手机号 */
        request.setPhoneNumbers(phone);
        /* 必填:短信签名-可在短信控制台中找到 */
        request.setSignName(ApplicationConfig.getSignName());
        /* 必填:短信模板code-可在短信控制台中找到 */
        request.setTemplateCode(ApplicationConfig.getTemplateCode());
        /* 可选:模板中的变量替换JSON串,如模板内容为"亲爱的用户,您的验证码为${code}"时,此处的值为 */
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        // hint 异常往上抛出
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }


}
