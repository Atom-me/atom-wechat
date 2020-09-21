package com.atom.wechat.handler.event;


import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.event.ReqUnsubscribeEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.EVENT_UNSUBSCRIBE;

/**
 * 取消订阅 无法再向用户推送消息
 *
 * @author Atom
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