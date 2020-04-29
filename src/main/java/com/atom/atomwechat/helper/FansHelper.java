package com.atom.atomwechat.helper;

import com.atom.atomwechat.constant.WeChatConstant;
import com.atom.atomwechat.model.fans.FansInfo;
import com.atom.atomwechat.model.fans.FansList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author atom
 */
@Component
@Slf4j
public class FansHelper {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private AccessTokenHelper accessTokenHelper;

    public FansList list() {
        FansList fansLis = restTemplate.getForObject(WeChatConstant.FANS_LIST_URL, FansList.class, accessTokenHelper.accessToken().getAccessToken(), "");
        log.info(fansLis.toString());
        return fansLis;
    }

    public FansInfo info(String openId) {
        FansInfo fansInfo = restTemplate.getForObject(WeChatConstant.FANS_INFO_URL, FansInfo.class, accessTokenHelper.accessToken().getAccessToken(), openId);
        log.info(fansInfo.toString());
        return fansInfo;
    }

}
