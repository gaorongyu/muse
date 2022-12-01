package com.fngry.muse.service;

import java.util.List;

/**
 * @author gaorongyu
 */
public interface CityService {

    /**
     * 根据cityId查询推荐关键字
     * @param cityId
     * @return
     */
    List<String> getRecommendKeyword(Long cityId);

}
