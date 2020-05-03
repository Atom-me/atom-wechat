package com.atom.atomwechat.handler.event;


import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.event.ReqViewEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.EVENT_VIEW;

/**
 * 点击菜单跳转链接时的事件推送事件处理器
 *
 * @author Atom
 */
@Component
@MsgType(type = EVENT_VIEW, msgClass = ReqViewEventMessage.class, desc = "点击菜单跳转链接时的事件推送事件处理器")
@Slf4j
public class ReqViewEventMsgHandler implements ReqMsgHandler<ReqViewEventMessage> {

    @Override
    public String process(ReqViewEventMessage reqViewEventMessage) {
        log.info("==========={}=============", EVENT_VIEW.getDesc());

        //todo process event response
        log.info(reqViewEventMessage.toString());


        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return EVENT_VIEW;
    }
}