package com.fngry.muse.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础entity
 *
 * @param <T>
 * @author gaorongyu
 */
@Data
public abstract class BaseEntity<T extends Model<?>> extends Model<T> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Date lastUpdate;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
