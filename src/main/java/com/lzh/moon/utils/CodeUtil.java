package com.lzh.moon.utils;

import java.util.Random;

/**
 * 生成随机码
 *
 * @author LiAnGzh
 * @date 2020/2/27 18:59
 */
public class CodeUtil {
    /**
     * 功能描述: 生成六位随机验证码
     */
    public static String getMsgCode() {
        int n = 6;
        StringBuilder code = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());
        }
        return code.toString();
    }
}
