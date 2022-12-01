package com.fngry.pelikan.common.result;

import java.util.Objects;

/**
 * 通用结果码
 * @author gaorongyu
 */
public enum ResultCode implements IResultCode {

    /** 成功 */
    OK("200", "OK"),
    /** 内部服务异常 */
    INTERNAL_SERVER_ERROR("10000001", "Internal Server Error"),
    /** 参数无效 */
    INVALID_PARAMETER("10000002", "Invalid parameter"),
    ;

    private final String code;

    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getMessage(Object... args) {
        return message != null ? String.format(this.message, args) : "";
    }

    public static ResultCode codeOf(String code) {
        for (ResultCode value : values()) {
            if (Objects.equals(value.code, code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

}