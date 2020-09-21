package com.atom.wechat.handler.normal;

import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.normal.ReqImageMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.IMAGE;

/**
 * 图片消息处理器
 *
 * @author Atom
 */
@Component
@MsgType(type = IMAGE, msgClass = ReqImageMessage.class, desc = "图片消息处理器")
@Slf4j
public class ReqImageMsgHandler implements ReqMsgHandler<ReqImageMessage> {
    @Override
    public String process(ReqImageMessage reqImageMessage) {
        log.info("==========={}=============", IMAGE.getDesc());
        log.info(reqImageMessage.toString());

        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return IMAGE;
    }
}
