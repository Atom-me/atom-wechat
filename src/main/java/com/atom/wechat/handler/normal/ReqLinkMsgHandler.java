package com.atom.wechat.handler.normal;

import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.normal.ReqLinkMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.LINK;

/**
 * 链接消息处理器
 *
 * @author Atom
 */
@Component
@Slf4j
@MsgType(type = LINK, msgClass = ReqLinkMessage.class, desc = "链接消息处理器")
public class ReqLinkMsgHandler implements ReqMsgHandler<ReqLinkMessage> {
    @Override
    public String process(ReqLinkMessage reqLinkMessage) {
        if (log.isDebugEnabled()) {
            log.debug("this is a debug message ");
        }

        log.info("==========={}=============", LINK.getDesc());
        log.info(reqLinkMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return LINK;
    }
}
