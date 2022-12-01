package com.fngry.pelikan.common.result;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果
 * <p>
 * 增加排序数组
 *
 * @author gaorongyu
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class Pagination implements Serializable {

    private static final long serialVersionUID = -9116780368553517783L;

    public static final int MAX_LIMIT = 10000;

    private Integer offset = 0;
    private Integer limit = 20;
    private Integer total = 0;
    private Integer page = 1;

    /**
     * 正序字段数组
     */
    protected List<String> ascFields;
    /**
     * 倒序字段数组
     */
    protected List<String> descFields;

    public Pagination() {
        ascFields = new ArrayList<>();
        descFields = new ArrayList<>();
    }

    public Pagination(Integer offset, Integer limit) {
        this();
        this.setOffset(offset);
        this.setLimit(limit);
    }

    public Pagination(Pagination pagination) {
        this();
        if (pagination == null) {
            throw new NullPointerException("pagination is null");
        }
        this.offset = pagination.offset;
        this.limit = pagination.limit;
        this.total = pagination.total;
        this.ascFields = pagination.getAscFields();
        this.descFields = pagination.getDescFields();
        if (pagination.page != null) {
            setPage(pagination.page);
        }
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        if (offset != null && offset >= 0) {
            this.offset = offset;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit != null && limit > 0) {
            if (limit > MAX_LIMIT) {
                limit = MAX_LIMIT;
            }
            this.limit = limit;
            //重新计算offset(post 方法初始化顺序问题)
            setPage(this.page);
        }
    }

    public void setPage(Integer page) {
        this.page = page;
        if (page != null && page > 0) {
            this.setOffset((page - 1) * this.limit);
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        if (total != null) {
            this.total = total;
        }
    }

    public Integer getStartPage() {
        return offset / limit + 1;
    }

    public Integer getPage() {
        return page;
    }

    public List<String> getAscFields() {
        return ascFields;
    }

    public void setAscFields(List<String> ascFields) {
        this.ascFields = ascFields;
    }

    public List<String> getDescFields() {
        return descFields;
    }

    public void setDescFields(List<String> descFields) {
        this.descFields = descFields;
    }

    @Override
    public String toString() {
        return "Pagination [offset=" + offset + ", limit=" + limit + ", total=" + total + "]";
    }

}
