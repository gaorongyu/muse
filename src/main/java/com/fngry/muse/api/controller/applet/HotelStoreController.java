package com.fngry.muse.api.controller.applet;

import com.fngry.muse.api.controller.applet.vo.HotelStoreListVo;
import com.fngry.muse.dao.dal.query.HotelStoreQuery;
import com.fngry.muse.dao.entity.VersionEntity;
import com.fngry.muse.dao.mapper.VersionMapper;
import com.fngry.muse.service.HotelStoreService;
import com.fngry.muse.service.bo.HotelStoreBo;
import com.fngry.pelikan.common.result.Page;
import com.fngry.pelikan.common.result.PageCondition;
import com.fngry.pelikan.common.utils.BeanCopiers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaorongyu
 */
@RestController
@RequestMapping("hotelStore")
public class HotelStoreController {

    @Autowired
    private HotelStoreService hotelStoreService;

    /**
     * 获取推荐列表
     * @param pageCondition
     * @return
     */
    @PostMapping("getRecommendHotelPage")
    public Page<HotelStoreListVo> getRecommendHotelPage(@RequestBody PageCondition<HotelStoreQuery> pageCondition) {
        Page<HotelStoreBo> boPage = hotelStoreService.page(pageCondition);
        return boPage.mapPage(e -> BeanCopiers.copy(e, HotelStoreListVo.class));
    }


}
