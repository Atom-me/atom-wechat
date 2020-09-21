package com.atom.wechat.handler.normal;

import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.normal.ReqVideoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.VIDEO;

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
