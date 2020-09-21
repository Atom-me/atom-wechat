package com.atom.wechat.handler.event;


import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.event.ReqClickEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.EVENT_CLICK;

/**
 * 点击菜单拉取消息时的事件推送消息处理器
 *
 * @author Atom
 */
@Component
@MsgType(type = EVENT_CLICK, msgClass = ReqClickEventMessage.class, desc = "点击菜单拉取消息时的事件推送消息处理器")
@Slf4j
public class ReqClickEventMsgHandler implements ReqMsgHandler<ReqClickEventMessage> {

    @Override
    public String process(ReqClickEventMessage reqClickEventMessage) {
        log.info("==========={}=============", EVENT_CLICK.getDesc());

        //todo process event response
        log.info(reqClickEventMessage.toString());

        String respXml = "<xml>\n" +
                "  <ToUserName><![CDATA[" + reqClickEventMessage.getFromUserName() + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + reqClickEventMessage.getToUserName() + "]]></FromUserName>\n" +
                "  <CreateTime>" + System.currentTimeMillis() / 1000 + "</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[北京市昌平区白各庄新村43号楼22单元109\n广州市人民中路与中山路交界处]]></Content>\n" +
                "</xml>";

        return respXml;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return EVENT_CLICK;
    }
}