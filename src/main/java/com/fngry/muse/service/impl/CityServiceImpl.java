package com.fngry.muse.service.impl;

import com.alibaba.fastjson.JSON;
import com.fngry.muse.dao.dal.JcChinaCityDao;
import com.fngry.muse.dao.entity.JcChinaCityEntity;
import com.fngry.muse.service.CityService;
import com.fngry.pelikan.common.utils.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaorongyu
 */
@Service
public class CityServiceImpl implements CityService {
    
    @Autowired
    private JcChinaCityDao jcChinaCityDao;
    
    @Override
    public List<String> getRecommendKeyword(Long cityId) {
        if (cityId == null) {
            return null;
        }
        JcChinaCityEntity city = jcChinaCityDao.getById(cityId);
        if (city != null && StringTool.isNotEmpty(city.getRecommendKeyword())) {
            return JSON.parseArray(city.getRecommendKeyword(), String.class);
        }
        return null;
    }
    
}
