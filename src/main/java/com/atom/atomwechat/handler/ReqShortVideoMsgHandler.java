package com.atom.atomwechat.handler;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.model.req.ReqShortVideoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atom
 */
@Component
@MsgType(type = ReqMsgTypeEnum.SHORTVIDEO, msgClass = ReqShortVideoMessage.class)
@Slf4j
public class ReqShortVideoMsgHandler implements ReqMsgHandler<ReqShortVideoMessage> {
    @Override
    public String process(ReqShortVideoMessage reqShortVideoMessage) {
        log.error("===========小视频消息消息=============");
        log.error(reqShortVideoMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.SHORTVIDEO;
    }
}
