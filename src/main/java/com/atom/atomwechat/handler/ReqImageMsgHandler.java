package com.atom.atomwechat.handler;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.model.req.ReqImageMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atom
 */
@Component
@MsgType(type = ReqMsgTypeEnum.IMAGE, msgClass = ReqImageMessage.class)
@Slf4j
public class ReqImageMsgHandler implements ReqMsgHandler<ReqImageMessage> {
    @Override
    public String process(ReqImageMessage reqImageMessage) {
        log.info("==========={}=============", ReqMsgTypeEnum.IMAGE.getDesc());
        log.info(reqImageMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.IMAGE;
    }
}
