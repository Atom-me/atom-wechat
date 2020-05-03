package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.normal.ReqShortVideoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.SHORT_VIDEO;

/**
 * 短视频消息处理器
 *
 * @author atom
 */
@Component
@MsgType(type = SHORT_VIDEO, msgClass = ReqShortVideoMessage.class, desc = "短视频消息处理器")
@Slf4j
public class ReqShortVideoMsgHandler implements ReqMsgHandler<ReqShortVideoMessage> {
    @Override
    public String process(ReqShortVideoMessage reqShortVideoMessage) {
        log.info("==========={}=============", SHORT_VIDEO.getDesc());
        log.info(reqShortVideoMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return SHORT_VIDEO;
    }
}
