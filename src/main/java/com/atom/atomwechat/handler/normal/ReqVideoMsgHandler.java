package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.normal.ReqVideoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.VIDEO;

/**
 * 视频消息处理器
 *
 * @author Atom
 */
@Component
@MsgType(type = VIDEO, msgClass = ReqVideoMessage.class, desc = "视频消息处理器")
@Slf4j
public class ReqVideoMsgHandler implements ReqMsgHandler<ReqVideoMessage> {
    @Override
    public String process(ReqVideoMessage reqVideoMessage) {
        log.info("==========={}=============", VIDEO.getDesc());
        log.info(reqVideoMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return VIDEO;
    }
}
