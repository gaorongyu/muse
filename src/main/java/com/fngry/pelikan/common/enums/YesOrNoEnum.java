package com.fngry.pelikan.common.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fngry.pelikan.common.enums.base.EnumType;

public enum YesOrNoEnum implements EnumType<Integer, String>, IEnum<Integer> {
    UNKNOWN(-1, "未知"),
    NO(0, "NO"),
    YES(1, "YES");

    private final int code;
    private final String text;

    private YesOrNoEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String text() {
        return this.text;
    }

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return code;
    }
}