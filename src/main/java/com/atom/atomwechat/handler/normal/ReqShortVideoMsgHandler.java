package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.normal.ReqShortVideoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atom
 */
@Component
@MsgType(type = ReqMsgTypeEnum.SHORT_VIDEO, msgClass = ReqShortVideoMessage.class)
@Slf4j
public class ReqShortVideoMsgHandler implements ReqMsgHandler<ReqShortVideoMessage> {
    @Override
    public String process(ReqShortVideoMessage reqShortVideoMessage) {
        log.info("==========={}=============", ReqMsgTypeEnum.SHORT_VIDEO.getDesc());
        log.info(reqShortVideoMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.SHORT_VIDEO;
    }
}
