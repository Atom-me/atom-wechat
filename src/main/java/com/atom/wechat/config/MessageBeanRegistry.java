package com.atom.wechat.config;

import com.atom.wechat.annotation.MsgType;
import com.atom.wechat.handler.ReqMsgHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * MessageBeanRegistry
 *
 * @author Atom
 */
@Component
public class MessageBeanRegistry implements InitializingBean {

    @Resource
    private List<ReqMsgHandler> msgHandlers;

    @Resource
    private MessageBeanContext messageBeanContext;

    @Override
    public void afterPropertiesSet() {
        msgHandlers.forEach(reqMsgHandler -> {
            Class<? extends ReqMsgHandler> clazz = reqMsgHandler.getClass();
            MsgType msgType = AnnotationUtils.getAnnotation(clazz, MsgType.class);
            if (Objects.isNull(msgType)) {
                return;
            }
            registerMessageBean(msgType, messageBeanContext);
        });
    }

    private void registerMessageBean(MsgType msgType, MessageBeanContext messageBeanContext) {
        Class messageBeanClass = msgType.msgClass();
        messageBeanContext.register(msgType.type(), messageBeanClass);
    }
}
