package com.atom.wechat.handler.event;


import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
import com.atom.wechat.model.req.event.ReqTemplateSendJobFinishEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.wechat.enums.ReqMsgTypeEnum.EVENT_TEMPLATE_SEND_JOB_FINISH;

/**
 * 在模版消息发送任务完成后的事件推送处理器
 *
 * @author Atom
 */
@Component
@MsgType(type = EVENT_TEMPLATE_SEND_JOB_FINISH, msgClass = ReqTemplateSendJobFinishEventMessage.class, desc = "在模版消息发送任务完成后的事件推送处理器")
@Slf4j
public class ReqTemplateSendJobFinishEventMsgHandler implements ReqMsgHandler<ReqTemplateSendJobFinishEventMessage> {

    @Override
    public String process(ReqTemplateSendJobFinishEventMessage reqTemplateSendJobFinishEventMessage) {
        log.info("==========={}=============", EVENT_TEMPLATE_SEND_JOB_FINISH.getDesc());

        //todo process event response
        /**
         * 在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知，发送到开发者在开发模式中填写的URL中
         * 在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知，发送到开发者在开发模式中填写的URL中。
         *
         * 1、送达成功时，推送的XML如下：
         *
         * 	<xml>
         *
         * 	<ToUserName><![CDATA[gh_7f083739789a]]></ToUserName>
         *
         * 	<FromUserName><![CDATA[oia2TjuEGTNoeX76QEjQNrcURxG8]]></FromUserName>
         *
         * 	<CreateTime>1395658920</CreateTime>
         *
         * 	<MsgType><![CDATA[event]]></MsgType>
         *
         * 	<Event><![CDATA[TEMPLATESENDJOBFINISH]]></Event>
         *
         * 	<MsgID>200163836</MsgID>
         *
         * 	<Status><![CDATA[success]]></Status>
         *
         * 	</xml>
         *
         *
         * 2、送达由于用户拒收（用户设置拒绝接收公众号消息）而失败时，推送的XML如下：
         *
         * 	<xml>
         *
         * 	<ToUserName><![CDATA[gh_7f083739789a]]></ToUserName>
         *
         * 	<FromUserName><![CDATA[oia2TjuEGTNoeX76QEjQNrcURxG8]]></FromUserName>
         *
         * 	<CreateTime>1395658984</CreateTime>
         *
         * 	<MsgType><![CDATA[event]]></MsgType>
         *
         * 	<Event><![CDATA[TEMPLATESENDJOBFINISH]]></Event>
         *
         * 	<MsgID>200163840</MsgID>
         *
         * 	<Status><![CDATA[failed:user block]]></Status>
         *
         * 	</xml>
         *
         *
         * 3、送达由于其他原因失败时，推送的XML如下：
         *
         * 	<xml>
         *
         * 	<ToUserName><![CDATA[gh_7f083739789a]]></ToUserName>
         *
         * 	<FromUserName><![CDATA[oia2TjuEGTNoeX76QEjQNrcURxG8]]></FromUserName>
         *
         * 	<CreateTime>1395658984</CreateTime>
         *
         * 	<MsgType><![CDATA[event]]></MsgType>
         *
         * 	<Event><![CDATA[TEMPLATESENDJOBFINISH]]></Event>
         *
         * 	<MsgID>200163840</MsgID>
         *
         * 	<Status><![CDATA[failed: system failed]]></Status>
         *
         * 	</xml>
         *
         */
        log.info(reqTemplateSendJobFinishEventMessage.toString());


        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return EVENT_TEMPLATE_SEND_JOB_FINISH;
    }
}