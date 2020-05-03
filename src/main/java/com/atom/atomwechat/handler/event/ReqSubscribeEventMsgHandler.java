package com.atom.atomwechat.handler.event;


import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.event.ReqSubscribeEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.EVENT_SUBSCRIBE;

/**
 * 关注事件处理器
 *
 * @author Atom
 */
@Component
@MsgType(type = EVENT_SUBSCRIBE, msgClass = ReqSubscribeEventMessage.class, desc = "关注事件处理器")
@Slf4j
public class ReqSubscribeEventMsgHandler implements ReqMsgHandler<ReqSubscribeEventMessage> {

    @Override
    public String process(ReqSubscribeEventMessage reqSubscribeEventMessage) {
        log.info("==========={}=============", EVENT_SUBSCRIBE.getDesc());

        //todo process event response
        log.info(reqSubscribeEventMessage.toString());

        String respXml = "<xml>\n" +
                "  <ToUserName><![CDATA[" + reqSubscribeEventMessage.getFromUserName() + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + reqSubscribeEventMessage.getToUserName() + "]]></FromUserName>\n" +
                "  <CreateTime>" + System.currentTimeMillis() / 1000 + "</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[hello 。。。。。。。。。。]]></Content>\n" +
                "</xml>";

        return respXml;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return EVENT_SUBSCRIBE;
    }
}