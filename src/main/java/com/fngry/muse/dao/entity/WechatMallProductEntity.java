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
 * 商城-商品
 * </p>
 *
 * @author gaorongyu
 * @since 2022-11-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wechat_mall_product")
public class WechatMallProductEntity extends BaseEntity<WechatMallProductEntity> {

    @TableField("uid")
    private Integer uid;

    /**
     * 1--普通商城 2--秒杀商城
     */
    @TableField("type")
    private Integer type;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 原价
     */
    @TableField("price_original")
    private BigDecimal priceOriginal;

    /**
     * 默认库存 不开启规格时的库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 是否开启规格 1--不开启  2--开启(开启后根据sku判断库存）
     */
    @TableField("spec_open")
    private Integer specOpen;

    /**
     * 服务保障 ,隔开
     */
    @TableField("attach_id")
    private String attachId;

    /**
     * 封面图片
     */
    @TableField("cover_img")
    private String coverImg;

    /**
     * 展示图片
     */
    @TableField("img_path")
    private String imgPath;

    /**
     * 图文详情
     */
    @TableField("description")
    private String description;

    /**
     * 是否发布 1--未发布 2--已发布
     */
    @TableField("is_publish")
    private Integer isPublish;

    /**
     * 发布时间
     */
    @TableField("publish_time")
    private Integer publishTime;

    /**
     * 是否推荐 1--未推荐 2--已推荐
     */
    @TableField("is_recommend")
    private Integer isRecommend;

    /**
     * 初始销量
     */
    @TableField("sales_origial_number")
    private Integer salesOrigialNumber;

    /**
     * 实际销量
     */
    @TableField("sales_actual_number")
    private Integer salesActualNumber;

    /**
     * 评价数量
     */
    @TableField("review_number")
    private Integer reviewNumber;

    /**
     * 是否参加过秒杀（1-否 2-是）
     */
    @TableField("is_spike")
    private Integer isSpike;

    /**
     * 软删除
     */
    @TableField("delete_time")
    private Integer deleteTime;

    /**
     * NOUSE 所属门店ID
     */
    @TableField("store_id")
    private Integer storeId;

    /**
     * NOUSE 搜索关键字
     */
    @TableField("keyword")
    private String keyword;

    /**
     * NOUSE 积分赠送%
     */
    @TableField("integral_gift_percent")
    private BigDecimal integralGiftPercent;

    /**
     * NOUSE 积分赠送固定金额
     */
    @TableField("integral_gift_pay")
    private BigDecimal integralGiftPay;

    /**
     * NOUSE 余额返现%
     */
    @TableField("balance_return_percent")
    private BigDecimal balanceReturnPercent;

    /**
     * NOUSE 余额返现固定金额
     */
    @TableField("balance_return_pay")
    private BigDecimal balanceReturnPay;

    /**
     * NOUSE 是否参与会员折扣 1--不参与 2--参与
     */
    @TableField("is_grade_discount")
    private Integer isGradeDiscount;

    /**
     * NOUSE 是否参与分销 1--不参与分销 2--参与分销
     */
    @TableField("join_distribution")
    private Integer joinDistribution;

    /**
     * NOUSE 是否独立分销规则 1--统一分销规则 2--独立规则 
     */
    @TableField("alone_rule")
    private Integer aloneRule;

    /**
     * NOUSE 运费类型 1--统一运费 2--运费模板
     */
    @TableField("freight_type")
    private Integer freightType;

    /**
     * NOUSE 运费模板id
     */
    @TableField("freight_id")
    private Integer freightId;

    /**
     * NOUSE 统一运费
     */
    @TableField("freight_money")
    private BigDecimal freightMoney;

    /**
     * NOUSE 是否包邮 1--包邮 2--不包邮
     */
    @TableField("is_free_freight")
    private Integer isFreeFreight;

}
