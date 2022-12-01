package com.fngry.muse.service;

import com.fngry.muse.dao.dal.query.HotelStoreQuery;
import com.fngry.muse.service.bo.HotelStoreBo;
import com.fngry.pelikan.common.result.Page;
import com.fngry.pelikan.common.result.PageCondition;

/**
 * @author gaorongyu
 */
public interface HotelStoreService {

    /**
     * 分页查询
     * @param pageCondition
     * @return
     */
    Page<HotelStoreBo> page(PageCondition<HotelStoreQuery> pageCondition);

}
