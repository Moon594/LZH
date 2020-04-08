package com.lzh.moon.common;

/**
 * 返回结果码
 *
 * @author shangzf
 * @date 2019/10/31 14:26
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(201, "失败"),
    /**
     * 方法未找到
     */
    NOT_FOUND_METHOD(404, "方法未找到"),
    /**
     * 方法请求方式不支持
     */
    NOT_SUPPORT_METHOD(403, "方法请求方式不支持"),
    /**
     * 服务器异常
     */
    ERROR(500, "服务器异常");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
