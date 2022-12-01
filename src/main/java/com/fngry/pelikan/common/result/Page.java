package com.fngry.pelikan.common.result;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分页参数
 *
 * @param <T>
 * @author gaorongyu
 */
public class Page<T> extends Pagination {

    private static final long serialVersionUID = 8005300029021219527L;

    private List<T> items = new LinkedList<T>();

    public Page() {
    }

    public Page(Pagination pagination) {
        super(pagination);
    }

    public List<T> getItems() {
        return items;
    }

    public Page<T> addItem(T obj) {
        items.add(obj);
        return this;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page [items=" + items + ", super=" + super.toString() + "]";
    }

    /**
     * 返回一个新的Page
     *
     * @param mapper
     * @param <R>
     * @return
     */
    public <R> Page<R> mapPage(Function<? super T, ? extends R> mapper) {
        Page<R> aPage = new Page<>(this);
        if (Objects.nonNull(getItems()) && getItems().size() > 0) {
            aPage.setItems(getItems().stream().map(mapper).collect(Collectors.toList()));
        }
        return aPage;
    }
}
