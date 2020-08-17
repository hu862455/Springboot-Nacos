package com.springboot.nacos.demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.springboot.nacos.demo.dto.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shuaihu2
 * @Date: 2020/8/15
 * @Interface: ConfigController
 * @Description: 演示如何获取服务器配置
 */

@Controller
@RequestMapping("config")
public class ConfigController {

    // 这里的useLocalCache:false是定义的缺省值，会根据Nacos的变化而变化的
    @NacosValue(value = "${sisi.name:none}", autoRefreshed = true)
    private String name;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return name;
    }

}
