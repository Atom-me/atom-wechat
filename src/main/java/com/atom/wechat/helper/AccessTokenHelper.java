package com.atom.wechat.helper;

import com.atom.wechat.model.resp.AccessTokenResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static com.atom.wechat.constant.WeChatConstant.*;

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
     * 公众平台的API调用所需的access_token，即微信接口调用凭证
     *
     * @return
     */
    @Cacheable(cacheNames = "accessTokenCache")
    public AccessTokenResp fetchAccessToken() {
        AccessTokenResp accessTokenResp = restTemplate.getForObject(ACCESS_TOKEN_URL, AccessTokenResp.class, APP_ID, APP_SECRET);
        log.info("get accessToken method from Tencent>>>>>>>>>>>>>>>>>>>>>>[{}]", accessTokenResp.toString());
        return accessTokenResp;
    }

}
