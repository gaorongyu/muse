package com.fngry.muse.dao.entity;

import java.math.BigDecimal;
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
 * 微信小程序hotel store
 * </p>
 *
 * @author gaorongyu
 * @since 2022-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wechat_hotel_store")
public class WechatHotelStoreEntity extends BaseEntity<WechatHotelStoreEntity> {

    @TableField("uid")
    private Integer uid;

    @TableField("cover_img")
    private String coverImg;

    @TableField("name")
    private String name;

    @TableField("is_publish")
    private Integer isPublish;

    @TableField("score")
    private Integer score;

    @TableField("use_num")
    private Integer useNum;

    @TableField("use_actual")
    private Integer useActual;

    @TableField("address")
    private String address;

    @TableField("store_label")
    private String storeLabel;

    @TableField("city_id")
    private Integer cityId;

    @TableField("lat")
    private BigDecimal lat;

    @TableField("lng")
    private BigDecimal lng;

    @TableField("facilities")
    private String facilities;

    @TableField("service")
    private String service;

    @TableField("description")
    private String description;

    @TableField("attach_id")
    private Integer attachId;

    @TableField("mobile_phone")
    private String mobilePhone;

    @TableField("check_in_instruction")
    private String checkInInstruction;

    @TableField("practice_time")
    private Integer practiceTime;

    @TableField("renovation_time")
    private Integer renovationTime;

    @TableField("delete_time")
    private Integer deleteTime;

    @TableField("show_img")
    private String showImg;

    @TableField("role_id")
    private Integer roleId;

    @TableField("keyword")
    private String keyword;

    @TableField("min_price")
    private BigDecimal minPrice;

    @TableField("hotel_type")
    private Integer hotelType;

    @TableField("store_tag")
    private String storeTag;

}
