package com.atom.wechat.handler.normal;

import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.normal.ReqShortVideoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.SHORT_VIDEO;

/**
 * 短视频消息处理器
 *
 * @author Atom
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
