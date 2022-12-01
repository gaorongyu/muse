package com.fngry.muse.api.controller.applet.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gaorongyu
 */
@Data
public class HotelStoreListVo {

    private Long id;

    private String coverImg;

    private String name;

    private Integer score;

    private Integer useNum;

    private String address;

    private Integer cityId;

    private String description;

    private BigDecimal minPrice;

    private List<String> storeTagList;

}
