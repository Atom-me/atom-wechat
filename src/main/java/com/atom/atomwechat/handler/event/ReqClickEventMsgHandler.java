package com.atom.atomwechat.handler.event;


import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.event.ReqClickEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * @author atom
 */
@Component
@MsgType(type = ReqMsgTypeEnum.EVENT_CLICK, msgClass = ReqClickEventMessage.class, desc = "点击菜单拉取消息时的事件推送消息处理器")
@Slf4j
public class ReqClickEventMsgHandler implements ReqMsgHandler<ReqClickEventMessage> {

    @Override
    public String process(ReqClickEventMessage reqClickEventMessage) {
        log.error("==========={}=============", ReqMsgTypeEnum.EVENT_CLICK.getDesc());
//        String event = reqClickEventMessge.getEvent();
//        String eventKey = reqClickEventMessge.getEventKey();

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
        return ReqMsgTypeEnum.EVENT_CLICK;
    }
}