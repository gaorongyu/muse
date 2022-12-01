package com.fngry.pelikan.common.enums.base;

/**
 *
 * 枚举类型接口
 *
 * @author gaorongyu
 * @Date 2019/1/4
 */
public interface EnumType<C, T> {

    /**
     * 获取枚举code
     * @return
     */
    C code();

    /**
     * 获取枚举描述
     * @return
     */
    T text();

    @SuppressWarnings("unchecked")
    default <E extends EnumType<C, T>, C, T> E codeOf(C code) {
        return EnumSupport.codeOf(code, (Class<E>) this.getClass());
    }

}
