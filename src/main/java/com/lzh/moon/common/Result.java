package com.lzh.moon.common;

/**
 * 返回结果
 *
 * @author shangzf
 * @date 2019/10/31 14:11
 */
public interface Result {
    /**
     * 获取状态码
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取返回的消息
     *
     * @return
     */
    String getMessage();
}
