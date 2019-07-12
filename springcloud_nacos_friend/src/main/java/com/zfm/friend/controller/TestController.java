package com.zfm.friend.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zfm
 * @Description TODO
 * @date 2019/7/12
 */
@RestController
public class TestController {
    private final RestTemplate restTemplate;
       @NacosValue(value = "${nacos.test}", autoRefreshed = true)
//    @Value("${nacos.test.properties}")
    private String testProperties;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {

        System.out.println(testProperties);
        return restTemplate.getForObject("http://nacos-user/echo/" + str, String.class);
    }
}