package com.atom.atomwechat.handler;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.model.req.ReqVideoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atom
 */
@Component
@MsgType(type = ReqMsgTypeEnum.VIDEO, msgClass = ReqVideoMessage.class)
@Slf4j
public class ReqVideoMsgHandler implements ReqMsgHandler<ReqVideoMessage> {
    @Override
    public String process(ReqVideoMessage reqVideoMessage) {
        log.error("===========视频消息消息=============");
        log.info(reqVideoMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.VIDEO;
    }
}
