package com.atom.atomwechat.helper;

import com.atom.atomwechat.constant.WeChatConstant;
import com.atom.atomwechat.model.resp.AccessTokenResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author atom
 */
@Component
@Slf4j
public class AccessTokenHelper {

    @Resource
    private RestTemplate restTemplate;

    @Cacheable(cacheNames = "accessTokenCache")
    public AccessTokenResp accessToken() {
        log.error("get accessToken method >>>>>>>>>>>>>>>>>>>>>>");
        AccessTokenResp accessTokenResp = restTemplate.getForObject(WeChatConstant.ACCESS_TOKEN_URL, AccessTokenResp.class, WeChatConstant.APP_ID, WeChatConstant.APP_SECRET);
        return accessTokenResp;
    }

}
