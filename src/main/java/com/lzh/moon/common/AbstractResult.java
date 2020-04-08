package com.lzh.moon.common;

/**
 * @author shangzf
 * @date 2019/10/31 14:19
 */
public abstract class AbstractResult implements Result {

    private Integer code;

    private String message;

    public AbstractResult(){}

    public AbstractResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取状态码
     *
     * @return
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * 获取返回的消息
     *
     * @return
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
