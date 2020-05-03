package com.atom.atomwechat.helper;

import com.atom.atomwechat.model.fans.FansList;
import com.atom.atomwechat.model.fans.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static com.atom.atomwechat.constant.WeChatConstant.FANS_INFO_URL;
import static com.atom.atomwechat.constant.WeChatConstant.FANS_LIST_URL;

/**
 * 粉丝，关注者
 *
 * @author Atom
 */
@Component
@Slf4j
public class FansHelper {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private AccessTokenHelper accessTokenHelper;

    public FansList list() {
        FansList fansLis = restTemplate.getForObject(FANS_LIST_URL, FansList.class, accessTokenHelper.fetchAccessToken().getAccessToken(), "");
        log.info(fansLis.toString());
        return fansLis;
    }

    public Subscriber info(String openId) {
        Subscriber subscriber = restTemplate.getForObject(FANS_INFO_URL, Subscriber.class, accessTokenHelper.fetchAccessToken().getAccessToken(), openId);
        log.info(subscriber.toString());
        return subscriber;
    }

}
