package com.fngry.muse.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fngry.muse.dao.dal.WechatHotelStoreDao;
import com.fngry.muse.dao.dal.query.HotelStoreQuery;
import com.fngry.muse.dao.entity.WechatHotelStoreEntity;
import com.fngry.muse.service.HotelStoreService;
import com.fngry.muse.service.bo.HotelStoreBo;
import com.fngry.pelikan.common.enums.StatusEnum;
import com.fngry.pelikan.common.result.Page;
import com.fngry.pelikan.common.result.PageAdapter;
import com.fngry.pelikan.common.result.PageCondition;
import com.fngry.pelikan.common.utils.BeanCopiers;
import com.fngry.pelikan.common.utils.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaorongyu
 */
@Service
public class HotelStoreServiceImpl implements HotelStoreService {

    @Autowired
    private WechatHotelStoreDao wechatHotelStoreDao;
    
    @Override
    public Page<HotelStoreBo> page(PageCondition<HotelStoreQuery> pageCondition) {
        PageAdapter<WechatHotelStoreEntity> pageAdapter = new PageAdapter<>(pageCondition);
        LambdaQueryWrapper<WechatHotelStoreEntity> wrapper = this.queryWrapper(pageCondition.getCondition());
        wechatHotelStoreDao.page(pageAdapter, wrapper);
        return pageAdapter.getOriginPage().mapPage(this::convertToHotelStoreBo);
    }

    private HotelStoreBo convertToHotelStoreBo(WechatHotelStoreEntity source) {
        HotelStoreBo target = BeanCopiers.copy(source, HotelStoreBo.class);
        if (target == null) {
            return null;
        }
        if (StringTool.isNotEmpty(source.getStoreTag())) {
            List<String> tagList = JSON.parseArray(source.getStoreTag(), String.class);
            target.setStoreTagList(tagList);
        }
        return target;
    }

    private LambdaQueryWrapper<WechatHotelStoreEntity> queryWrapper(HotelStoreQuery query) {
        LambdaQueryWrapper<WechatHotelStoreEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(WechatHotelStoreEntity::getStatus, StatusEnum.NORMAL.code());
        if (query.getCityId() != null) {
            wrapper.eq(WechatHotelStoreEntity::getCityId, query.getCityId());
        }
        if (query.getHotelType() != null) {
            wrapper.eq(WechatHotelStoreEntity::getHotelType, query.getHotelType());
        }
        return wrapper;
    }

}
