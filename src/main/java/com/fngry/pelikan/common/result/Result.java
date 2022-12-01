package com.fngry.pelikan.common.result;

import java.io.Serializable;

/**
 *
 * @param <T>
 * @author gaorongyu
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4659831046550353276L;

    private String code;

    private String message;

    private T data;

    public static <D> Result<D> success(D data) {
        Result<D> result = new Result<>();
        result.code = ResultCode.OK.getCode();
        result.message = ResultCode.OK.getMessage();
        result.data = data;
        return result;
    }

    public static <D> Result<D> error(String code, String message) {
        Result<D> result = new Result<>();
        result.code = code;
        result.message = message;
        return result;
    }

    public static <D> Result<D> error(IResultCode resultCode) {
        Result<D> result = new Result<>();
        result.code = resultCode.getCode();
        result.message = resultCode.getMessage();
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return ResultCode.OK.getCode().equals(this.code);
    }

}
