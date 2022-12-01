package com.fngry.pelikan.common.enums.base;

import java.util.Arrays;

/**
 * 枚举辅助类
 *
 * @author gaorongyu
 * @Date 2019/1/9
 */
public class EnumSupport {

    /**
     * 根据 code 获取枚举
     *
     * @param code  枚举code
     * @param clazz 枚举类型class
     * @param <E>   枚举类型范型
     * @param <C>   code类型
     * @param <T>   text类型
     * @return 枚举
     */
    public static <E extends EnumType<C, T>, C, T> E codeOf(C code, Class<E> clazz) {
        if (code == null) {
            return null;
        }
        if (clazz == null) {
            throw new IllegalArgumentException("params is null");
        }
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> code.equals(e.code()))
                .findFirst()
                .orElse(null);
    }

    /**
     * 获取code值
     *
     * @param enumType
     * @param <C>
     * @param <T>
     * @return
     */
    public static <C, T> C safeGetCode(EnumType<C, T> enumType) {
        return enumType != null ? enumType.code() : null;
    }

    /**
     * 获取text值
     *
     * @param enumType
     * @param <C>
     * @param <T>
     * @return
     */
    public static <C, T> T safeGetText(EnumType<C, T> enumType) {
        return enumType != null ? enumType.text() : null;
    }

    /**
     * 根据code获取text值
     *
     * @param code
     * @param <C>
     * @param <T>
     * @return
     */
    public static <E extends EnumType<C, T>, C, T> T safeGetTextByCode(C code, Class<E> clazz) {
        return safeGetText(codeOf(code, clazz));
    }

}
