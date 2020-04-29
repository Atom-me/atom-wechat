package com.atom.atomwechat.factory;

import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.handler.ReqMsgHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Atom
 */
@Component
public class ReqMsgHandlerFactory implements ApplicationContextAware {
    private static Map<ReqMsgTypeEnum, ReqMsgHandler> handlerMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ReqMsgHandler> beansOfType = applicationContext.getBeansOfType(ReqMsgHandler.class);
        beansOfType.forEach((k, v) -> handlerMap.put(v.getMsgType(), v));
    }

    public ReqMsgHandler getReqMsgHandler(ReqMsgTypeEnum msgTypeEnum) {
        return handlerMap.get(msgTypeEnum);
    }
}
