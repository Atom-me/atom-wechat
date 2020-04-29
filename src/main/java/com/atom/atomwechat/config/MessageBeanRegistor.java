package com.atom.atomwechat.config;

import com.atom.atomwechat.annotation.MsgType;
import com.atom.atomwechat.handler.ReqMsgHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author atom
 */
@Component
public class MessageBeanRegistor implements InitializingBean {

    @Resource
    private List<ReqMsgHandler> msgHandlers;

    @Resource
    private MessageBeanContext messageBeanContext;

    @Override
    public void afterPropertiesSet() {
        msgHandlers.forEach(reqMsgHandler -> {
            Class<? extends ReqMsgHandler> clazz = reqMsgHandler.getClass();
            MsgType msgType = AnnotationUtils.getAnnotation(clazz, MsgType.class);
            if (Objects.isNull(msgType)){
                return;
            }
            registerMessageBean(msgType, messageBeanContext);
        });
    }

    private void registerMessageBean(MsgType msgType, MessageBeanContext messageBeanContext) {
        Class messageBeanClass = msgType.msgClass();
        messageBeanContext.registerMessageBean(msgType.type(), messageBeanClass);
    }
}
