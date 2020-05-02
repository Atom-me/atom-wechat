package com.atom.atomwechat.handler.event;


import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.event.ReqUnsubscribeEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 取消订阅 无法再向用户推送消息
 *
 * @author atom
 */
@Component
@MsgType(type = ReqMsgTypeEnum.EVENT_UNSUBSCRIBE, msgClass = ReqUnsubscribeEventMessage.class, desc = "取消订阅事件处理器")
@Slf4j
public class ReqUnsubscribeEventMsgHandler implements ReqMsgHandler<ReqUnsubscribeEventMessage> {

    @Override
    public String process(ReqUnsubscribeEventMessage reqUnsubscribeEventMessage) {
        log.error("==========={}=============", ReqMsgTypeEnum.EVENT_UNSUBSCRIBE.getDesc());
//        String event = reqClickEventMessge.getEvent();
//        String eventKey = reqClickEventMessge.getEventKey();

        //todo process event response
        log.info(reqUnsubscribeEventMessage.toString());

        return null;

    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.EVENT_UNSUBSCRIBE;
    }
}