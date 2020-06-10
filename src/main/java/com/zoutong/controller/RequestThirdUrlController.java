package com.zoutong.controller;

import com.zoutong.utils.TestUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.net.URI;

/**
 * @Description
 * @ClassName RequestThirdUrlController
 * @Author zoutong
 * @date 2020.06.10 11:39
 */
@Slf4j
@Controller
public class RequestThirdUrlController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${thirdinfo.ipRequestUrl}")
    private String requestUrl;
    @Value("${baidu.ak}")
    private String ak;
    @Value("${baidu.coor}")
    private String coor;

    @ResponseBody
    @RequestMapping("/baidu")
    public Object requestThirdUrl(String ipAddr){

        System.out.println("1111111111111111");

        System.out.println("url--"+requestUrl);
        System.out.println("ak--"+ak);
        System.out.println("coor--"+coor);

        //http://api.map.baidu.com/location/ip?ak=您的AK&ip=您的IP&coor=bd09l
        String urlStr = requestUrl + "?ak="+ak+"&ip=180.110.103.188&coor="+coor;

        System.out.println("urlStr=="+urlStr);

        ResponseEntity<String> res = restTemplate.getForEntity(

                urlStr,

                String.class);

        return TestUtils.UnicodeToUtf8(res.getBody());

    }

}
