package com.atom.wechat.factory;

import com.atom.wechat.enums.ReqMsgTypeEnum;
import com.atom.wechat.handler.ReqMsgHandler;
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

    /**
     * 获取消息处理器
     *
     * @param msgTypeEnum
     * @return
     */
    public ReqMsgHandler getReqMsgHandler(ReqMsgTypeEnum msgTypeEnum) {
        return handlerMap.get(msgTypeEnum);
    }
}
