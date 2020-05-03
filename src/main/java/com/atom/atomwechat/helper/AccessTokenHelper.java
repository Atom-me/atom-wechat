package com.atom.atomwechat.helper;

import com.atom.atomwechat.model.resp.AccessTokenResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static com.atom.atomwechat.constant.WeChatConstant.*;

/**
 * @author Atom
 */
@Component
@Slf4j
public class AccessTokenHelper {

    @Resource
    private RestTemplate restTemplate;

    /**
     * fetch AccessToken.
     *
     * @return
     */
    @Cacheable(cacheNames = "accessTokenCache")
    public AccessTokenResp fetchAccessToken() {
        AccessTokenResp accessTokenResp = restTemplate.getForObject(ACCESS_TOKEN_URL, AccessTokenResp.class, APP_ID, APP_SECRET);
        log.info("get accessToken method from Tencent>>>>>>>>>>>>>>>>>>>>>>" + accessTokenResp.toString());
        return accessTokenResp;
    }

}
