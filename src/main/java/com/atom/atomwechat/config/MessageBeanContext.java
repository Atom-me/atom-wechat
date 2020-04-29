package com.atom.atomwechat.config;

import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author atom
 */
@Component
public class MessageBeanContext {

    private ConcurrentHashMap<ReqMsgTypeEnum, Class> messageBeanMap;

    public void registerMessageBean(ReqMsgTypeEnum type, Class messageBeanClass) {
        if (CollectionUtils.isEmpty(messageBeanMap)) {
            messageBeanMap = new ConcurrentHashMap<>(20);
        }
        messageBeanMap.put(type, messageBeanClass);
    }

    public Class getMessageBeanClass(ReqMsgTypeEnum reqMsgType) {
        if (Objects.isNull(messageBeanMap.get(reqMsgType))) {
            throw new RuntimeException("未注册本消息的对应处理器>>>" + reqMsgType.getDesc());
        }
        return messageBeanMap.get(reqMsgType);
    }
}
