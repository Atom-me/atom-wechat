package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.normal.ReqImageMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.IMAGE;

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
