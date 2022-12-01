package com.fngry.pelikan.common.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fngry.pelikan.common.enums.base.EnumType;

/**
 *
 * 通用状态
 *
 * @author gaorongyu
 * @Date 2019/1/9
 */
public enum StatusEnum implements EnumType<Integer, String>, IEnum<Integer> {
    // 枚举项
    DELETED(-1, "已删除"),
    UNKNOWN(0, "未知"),
    NORMAL(1, "正常(有效)"),
    INVALID(2, "无效"),
    DISABLED(3, "失效");

    private final Integer code;

    private final String text;

    StatusEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String text() {
        return text;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }

}
