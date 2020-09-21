package com.atom.wechat.handler.normal;

import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.normal.ReqVoiceMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.VOICE;

/**
 * 语音消息处理器
 *
 * @author Atom
 */
@MsgType(type = VOICE, msgClass = ReqVoiceMessage.class, desc = "语音消息处理器")
@Component
@Slf4j
public class ReqVoiceMsgHandler implements ReqMsgHandler<ReqVoiceMessage> {
    @Override
    public String process(ReqVoiceMessage reqVoiceMessage) {
        log.info("==========={}=============", VOICE.getDesc());
        log.info(reqVoiceMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return VOICE;
    }
}
