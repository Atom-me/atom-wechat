package com.atom.wechat.handler.event;


import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.event.ReqLocationSelectEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.EVENT_LOCATION_SELECT;

/**
 * 发送地理位置事件推送 消息处理器
 *
 * @author Atom
 */
@Component
@MsgType(type = EVENT_LOCATION_SELECT, msgClass = ReqLocationSelectEventMessage.class, desc = "发送地理位置事件推送 消息处理器")
@Slf4j
public class ReqLocationSelectEventMsgHandler implements ReqMsgHandler<ReqLocationSelectEventMessage> {

    @Override
    public String process(ReqLocationSelectEventMessage reqLocationSelectEventMessage) {
        log.info("==========={}=============", EVENT_LOCATION_SELECT.getDesc());

        //todo process event response
        log.info(reqLocationSelectEventMessage.toString());


        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return EVENT_LOCATION_SELECT;
    }
}