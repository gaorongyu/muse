package com.fngry.pelikan.common.exception;

import com.fngry.pelikan.common.result.IResultCode;

/**
 * 业务异常
 * 通常需要在controller层做拦截处理, 把业务异常封装成调用方可读的信息
 *
 * @author gaorongyu
 * @Date 2018/12/18
 */
public class BizException extends RuntimeException {

    /**
     * 错误码
     */
    private IResultCode resultCode;
    /**
     * 额外信息
     */
    private Object[] extra;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BizException(IResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public IResultCode getResultCode() {
        return this.resultCode;
    }


    public Object[] getExtra() {
        return extra;
    }

    public BizException setExtra(Object... extra) {
        this.extra = extra;
        return this;
    }

}
