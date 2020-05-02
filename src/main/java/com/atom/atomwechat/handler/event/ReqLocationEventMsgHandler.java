package com.atom.atomwechat.handler.event;


import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.event.ReqLocationEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 上报地理位置事件处理器
 * 用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，
 * 或在进入会话后每5秒上报一次地理位置，公众号可以在公众平台网站中修改以上设置。
 *
 * @author atom
 */
@Component
@MsgType(type = ReqMsgTypeEnum.EVENT_LOCATION, msgClass = ReqLocationEventMessage.class, desc = "上报地理位置事件处理器")
@Slf4j
public class ReqLocationEventMsgHandler implements ReqMsgHandler<ReqLocationEventMessage> {

    @Override
    public String process(ReqLocationEventMessage reqLocationEventMessage) {
        log.info("==========={}=============", ReqMsgTypeEnum.EVENT_LOCATION.getDesc());

        //todo process event response
        log.info(reqLocationEventMessage.toString());
        String respXml = "<xml>\n" +
                "  <ToUserName><![CDATA[" + reqLocationEventMessage.getFromUserName() + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + reqLocationEventMessage.getToUserName() + "]]></FromUserName>\n" +
                "  <CreateTime>" + System.currentTimeMillis() / 1000 + "</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[已收到您的位置信息。。。。。]]></Content>\n" +
                "</xml>";

        return respXml;

    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.EVENT_LOCATION;
    }
}