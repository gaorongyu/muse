package com.fngry.pelikan.common.result;

import java.util.Objects;
import java.util.function.Function;

/**
 * 分页条件包装类
 *
 */
@SuppressWarnings({"rawtypes"})
public class PageCondition<T> extends Page {

    public PageCondition(PageCondition pageCondition, T condition) {
        this(pageCondition);
        setCondition(condition);
    }

    public PageCondition(PageCondition pageCondition) {
        super(pageCondition);
        setPage(pageCondition.getPage());
    }

    public PageCondition() {
    }

    private static final long serialVersionUID = 1836191939673111780L;

    private T condition;

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    /**
     * 返回一个新的PageCondition实例
     *
     * @param function
     * @param <R>
     * @return
     */
    public <R> PageCondition<R> mapPageCondition(Function<T, R> function) {
        return new PageCondition<>(this, function.apply(condition));
    }

    /**
     * 检查是否为空
     *
     * @param pageCondition
     */
    public static void nilValidate(PageCondition pageCondition) {
        checkArgument(Objects.nonNull(pageCondition), "param 'pageCondition' can not null");
        checkArgument(Objects.nonNull(pageCondition.getCondition()), "param 'condition' can not be null");
    }

    public static void checkArgument(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }
}
