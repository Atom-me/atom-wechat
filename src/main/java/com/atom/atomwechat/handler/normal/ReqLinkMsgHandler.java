package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.normal.ReqLinkMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atom
 */
@Component
@Slf4j
@MsgType(type = ReqMsgTypeEnum.LINK, msgClass = ReqLinkMessage.class)
public class ReqLinkMsgHandler implements ReqMsgHandler<ReqLinkMessage> {
    @Override
    public String process(ReqLinkMessage reqLinkMessage) {
        if (log.isDebugEnabled()) {
            log.debug("this is a debug message ");
        }

        log.info("==========={}=============", ReqMsgTypeEnum.LINK.getDesc());
        log.info(reqLinkMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.LINK;
    }
}