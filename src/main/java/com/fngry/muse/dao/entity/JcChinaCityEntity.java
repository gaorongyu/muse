package com.fngry.muse.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fngry.muse.dao.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaorongyu
 * @since 2022-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("jc_china_city")
public class JcChinaCityEntity extends BaseEntity<JcChinaCityEntity> {

    /**
     * 市
     */
    @TableField("name")
    private String name;

    /**
     * 省级id
     */
    @TableField("province_id")
    private Integer provinceId;

    @TableField("is_special")
    private Integer isSpecial;

    @TableField("is_hot")
    private Integer isHot;

    /**
     * 推荐关键字
     */
    @TableField("recommend_keyword")
    private String recommendKeyword;

}
