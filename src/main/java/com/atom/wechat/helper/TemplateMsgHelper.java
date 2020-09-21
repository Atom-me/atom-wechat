package com.atom.wechat.helper;

import com.atom.wechat.model.templatemessage.TemplateMsg;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static com.atom.wechat.constant.WeChatConstant.TEMPLATE_SEND_URL;


/**
 * @author Atom
 */
@Slf4j
@Component
public class TemplateMsgHelper {

    @Resource
    private AccessTokenHelper accessTokenHelper;

    @Resource
    private RestTemplate restTemplate;

    /**
     * 发送模板消息
     *
     * @param templateMsg
     * @return
     * @throws JsonProcessingException
     */
    public String send(TemplateMsg templateMsg) throws JsonProcessingException {
        String url = TEMPLATE_SEND_URL.replace("ACCESS_TOKEN", accessTokenHelper.fetchAccessToken().getAccessToken());
        String templateMsgJson = new ObjectMapper().writeValueAsString(templateMsg);
        log.info("send template message request params: {}", templateMsgJson);
        String result = restTemplate.postForObject(url, templateMsgJson, String.class);
        log.info("send template message result: {}", result);
        return result;
    }

}
