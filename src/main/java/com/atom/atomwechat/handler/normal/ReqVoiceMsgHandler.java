package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.normal.ReqVoiceMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author atom
 */
@MsgType(type = ReqMsgTypeEnum.VOICE, msgClass = ReqVoiceMessage.class)
@Component
@Slf4j
public class ReqVoiceMsgHandler implements ReqMsgHandler<ReqVoiceMessage> {
    @Override
    public String process(ReqVoiceMessage reqVoiceMessage) {
        log.info("==========={}=============", ReqMsgTypeEnum.VOICE.getDesc());
        log.info(reqVoiceMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.VOICE;
    }
}
