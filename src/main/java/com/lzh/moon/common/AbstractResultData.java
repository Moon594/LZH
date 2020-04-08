package com.lzh.moon.common;

/**
 * @author shangzf
 * @date 2019/10/31 19:03
 */
public abstract class AbstractResultData extends AbstractResult implements ResultData {

    private Object data;

    public AbstractResultData(){}

    public AbstractResultData(Object data){
        super(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage());
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
