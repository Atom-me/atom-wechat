package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.normal.ReqLocationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.LOCATION;

/**
 * 地理位置消息处理器
 *
 * @author Atom
 */
@MsgType(type = LOCATION, msgClass = ReqLocationMessage.class, desc = "地理位置消息处理器")
@Component
@Slf4j
public class ReqLocationMsgHandler implements ReqMsgHandler<ReqLocationMessage> {
    @Override
    public String process(ReqLocationMessage reqLocationMessage) {
        log.info("===========地理位置消息=============");
        log.info(reqLocationMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return LOCATION;
    }
}
