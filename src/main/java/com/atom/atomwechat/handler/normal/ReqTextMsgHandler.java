package com.atom.atomwechat.handler.normal;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.helper.RespMessageHelper;
import com.atom.atomwechat.model.req.normal.ReqTextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.TEXT;

/**
 * 文本消息处理器
 *
 * @author atom
 */
@Component
@MsgType(type = TEXT, msgClass = ReqTextMessage.class, desc = "文本消息处理器")
@Slf4j
public class ReqTextMsgHandler implements ReqMsgHandler<ReqTextMessage> {

    @Resource
    private RespMessageHelper respMessageHelper;

    @Override
    public String process(ReqTextMessage reqTextMessage) {
        log.info("==========={}=============", TEXT.getDesc());
        log.info(reqTextMessage.toString());

        String respXml = "<xml>\n" +
                "  <ToUserName><![CDATA[" + reqTextMessage.getFromUserName() + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + reqTextMessage.getToUserName() + "]]></FromUserName>\n" +
                "  <CreateTime>" + System.currentTimeMillis() / 1000 + "</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[阿童木啊啊啊啊]]></Content>\n" +
                "</xml>";

        if ("图文".equals(reqTextMessage.getContent())) {
            respXml = respMessageHelper.buildMediaArticleMsg(reqTextMessage);
            log.info(respXml);
        }

        return respXml;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return TEXT;
    }
}
