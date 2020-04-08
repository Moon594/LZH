package com.lzh.moon.common;

/**
 * 默认返回结果
 *
 * @author shangzf
 * @date 2019/10/31 14:23
 */
public class DefaultResult extends AbstractResult {

    public DefaultResult() {
    }

    public DefaultResult(ResultCode resultCode) {
        super(resultCode.getCode(), resultCode.getMessage());
    }
}
