package com.atom.wechat.handler.normal;

import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.normal.ReqLocationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.LOCATION;

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
