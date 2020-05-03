package com.atom.atomwechat.handler.event;


import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.event.ReqUnsubscribeEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.EVENT_UNSUBSCRIBE;

/**
 * 取消订阅 无法再向用户推送消息
 *
 * @author atom
 */
@Component
@MsgType(type = EVENT_UNSUBSCRIBE, msgClass = ReqUnsubscribeEventMessage.class, desc = "取消订阅事件处理器")
@Slf4j
public class ReqUnsubscribeEventMsgHandler implements ReqMsgHandler<ReqUnsubscribeEventMessage> {

    @Override
    public String process(ReqUnsubscribeEventMessage reqUnsubscribeEventMessage) {
        log.info("==========={}=============", EVENT_UNSUBSCRIBE.getDesc());

        //todo process event response
        log.info(reqUnsubscribeEventMessage.toString());

        return null;

    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return EVENT_UNSUBSCRIBE;
    }
}