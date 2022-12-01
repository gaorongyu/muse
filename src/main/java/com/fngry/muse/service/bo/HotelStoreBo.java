package com.fngry.muse.service.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gaorongyu
 */
@Data
public class HotelStoreBo {

    private Long id;

    private Integer uid;

    private String coverImg;

    private String name;

    private Integer isPublish;

    private Integer score;

    private Integer useNum;

    private Integer useActual;

    private String address;

    private String storeLabel;

    private Integer cityId;

    private BigDecimal lat;

    private BigDecimal lng;

    private String facilities;

    private String service;

    private String description;

    private Integer attachId;

    private String mobilePhone;

    private String checkInInstruction;

    private Integer practiceTime;

    private Integer renovationTime;

    private Integer deleteTime;

    private String showImg;

    private Integer roleId;

    private String keyword;

    private BigDecimal minPrice;

    private String storeTag;

    private List<String> storeTagList;

}
