package com.fngry.pelikan.common.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * MyBatis_Plus适配原始的分页组件 -> {@link Page}
 *
 * @author zhouze
 * @date 2019-06-20
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class PageAdapter<T> implements IPage<T> {

    /**
     * 原始的分页组件
     */
    private Page<T> page;
    /**
     * asc list
     */
    private String[] ascArray;
    /**
     * desc list
     */
    private String[] descArray;

    /**
     * 是否要count
     */
    private boolean searchCount = true;


    private static String ASC  = "asc";
    private static String DESC = "desc";


    public PageAdapter(Page page) {
        //set adapter
        this.page = page;

        //set order field
        if (Objects.nonNull(page.getAscFields())) {
            String[] ascs = new String[] {};
            ascs = page.getAscFields().toArray(ascs);
            setAscs(ascs);
        }
        if (Objects.nonNull(page.getDescFields())) {
            String[] descs = new String[] {};
            descs = page.getDescFields().toArray(descs);
            setDescs(descs);
        }
    }

    private PageAdapter() {
    }

    /**
     * 获取原始分页
     *
     * @return {@link Page}
     */
    public Page<T> getOriginPage() {
        return page;
    }

    @Override
    public List<T> getRecords() {
        return page.getItems();
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        page.setItems(records);
        return this;
    }

    @Override
    public long getTotal() {
        return page.getTotal();
    }

    @Override
    public IPage<T> setTotal(long total) {
        page.setTotal((int) total);
        return this;
    }

    @Override
    public long getSize() {
        return page.getLimit();
    }

    @Override
    public IPage<T> setSize(long size) {
        page.setLimit((int) size);
        return this;
    }

    @Override
    public long getCurrent() {
        return page.getPage();
    }

    @Override
    public IPage<T> setCurrent(long current) {
        page.setPage((int) current);
        return this;
    }

    @Override
    public String[] descs() {
        return descArray;
    }

    @Override
    public String[] ascs() {
        return ascArray;
    }


    @Override
    public boolean isSearchCount() {
        return searchCount;
    }

    @Override
    public List<OrderItem> orders() {
        //set order field
        List<OrderItem> ascOrderItemList = new ArrayList<>();
        List<OrderItem> descOrderItemList = new ArrayList<>();

        if (Objects.nonNull(this.ascArray)) {
            ascOrderItemList = OrderItem.ascs(this.ascArray);
        }
        if (Objects.nonNull(this.descArray)) {
            descOrderItemList = OrderItem.descs(this.descArray);
        }
        ascOrderItemList.addAll(descOrderItemList);

        return ascOrderItemList;
    }

    public IPage<T> setAscs(String[] a) {
        this.ascArray = a;
        return this;
    }

    public IPage<T> setDescs(String[] d) {
        this.descArray = d;
        return this;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }
}
