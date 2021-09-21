package com.fngry.muse.api.controller;

import com.fngry.muse.dao.entity.VersionEntity;
import com.fngry.muse.dao.mapper.VersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaorongyu
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private VersionMapper versionMapper;

    @GetMapping("hello")
    public String hello(@RequestParam("greeting") String greeting) {
        return "hello " + greeting;
    }

    @GetMapping("getLatestVersion")
    public String getLatestVersion() {
        VersionEntity versionEntity = versionMapper.selectById(1L);
        return versionEntity.toString();
    }

}
