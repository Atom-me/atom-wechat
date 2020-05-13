package com.atom.atomwechat.handler.event;


import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.req.event.ReqTemplateSendJobFinishEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.atom.atomwechat.enums.ReqMsgTypeEnum.EVENT_TEMPLATE_SEND_JOB_FINISH;

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
        log.info(reqTemplateSendJobFinishEventMessage.toString());


        return null;
    }

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return EVENT_TEMPLATE_SEND_JOB_FINISH;
    }
}