package com.lzh.moon.Config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 获取配置文件
 *
 * @author GideonYeung
 */
@Component
public class ApplicationConfig {

    private static String signName;
    private static String templateCode;
    private static String accessKeyId;
    private static String accessKeySecret;

    public static String getSignName() {
        return signName;
    }

    @Value("${aLiYun.signName}")
    public void setSignName(String signName) {
        this.signName = signName;
    }

    public static String getTemplateCode() {
        return templateCode;
    }

    @Value("${aLiYun.templateCode}")
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public static String getAccessKeyId() {
        return accessKeyId;
    }

    @Value("${aLiYun.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }

    @Value("${aLiYun.accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
