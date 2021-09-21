package com.fngry.muse.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * @author gaorongyu
 */
@TableName("muse_version")
public class VersionEntity extends Model<VersionEntity> {

    private Long id;

    private String tag;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "VersionEntity{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}
