package com.fngry.pelikan.common.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * bean copy工具
 *   基于cglib beanCopier
 * @author gaorongyu
 */
public class BeanCopiers {

    private static Map<String, FastBeanCopier> COPIER_CACHE = new HashMap<>();

    public static void register(Class srcClass, Class destClass, Converter converter) {
        COPIER_CACHE.put(generateCacheKey(srcClass.getName(), destClass.getName()),
                FastBeanCopier.create(srcClass, destClass, converter));
    }

    public static void copy(Object src, Object dest) {
        Assert.notNull(src, "src object can not null");
        Assert.notNull(dest, "dest object can not null");
        String key = generateCacheKey(src.getClass().getName(), dest.getClass().getName());
        FastBeanCopier fastBeanCopier = COPIER_CACHE.get(key);
        if (fastBeanCopier == null) {
            COPIER_CACHE.putIfAbsent(key, FastBeanCopier.create(src.getClass(), dest.getClass(), null));
            fastBeanCopier = COPIER_CACHE.get(key);
        }
        fastBeanCopier.copy(src, dest);
    }

    public static <T> T copy(Object src, Class<T> destClass) {
        Assert.notNull(destClass, "destClass object can not null");
        if (src == null) {
            return null;
        }
        T destObject;
        try {
            destObject = destClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("exception in create dest instance", e);
        }
        copy(src, destObject);
        return destObject;
    }

    public static <S, T> List<T> copyList(List<S> srcList, Class<T> destItemClass) {
        return srcList == null ? null : srcList.stream().map(e -> copy(e, destItemClass)).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> copyList(List<T> srcList) {
        if (srcList == null) {
            return null;
        }
        if (srcList.size() == 0) {
            return new ArrayList<>();
        }
        Class<T> clazz = (Class<T>) srcList.get(0).getClass();
        return srcList.stream().map(e -> copy(e, clazz)).collect(Collectors.toList());
    }

    private static String generateCacheKey(String srcClassName, String destClassName) {
        return String.join("_", srcClassName, destClassName);
    }

    /**
     * beanCopier 和 converter的封装
     * @author gaorongyu
     */
    private static class FastBeanCopier {

        /**
         * bean copier
         */
        private BeanCopier beanCopier;

        /**
         * 属性转换器
         */
        private Converter converter;

        private FastBeanCopier(Class srcClass, Class destClass, Converter converter) {
            this.beanCopier = BeanCopier.create(srcClass, destClass, converter != null);
            this.converter = converter;
        }

        public static FastBeanCopier create(Class srcClass, Class destClass, Converter converter) {
           return new FastBeanCopier(srcClass, destClass, converter);
        }

        public void copy(Object src, Object dest) {
            this.beanCopier.copy(src, dest, this.converter);
        }
    }

}
