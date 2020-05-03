package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.normal.ReqVideoMessage;
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
        log.info("==========={}=============", ReqMsgTypeEnum.VIDEO.getDesc());
        log.info(reqVideoMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.VIDEO;
    }
}
