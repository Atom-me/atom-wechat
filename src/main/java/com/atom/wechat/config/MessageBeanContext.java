package com.atom.wechat.config;

import com.atom.wechat.enums.ReqMsgTypeEnum;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Atom
 */
@Component
public class MessageBeanContext {

    private ConcurrentHashMap<ReqMsgTypeEnum, Class> messageBeanMap;

    public void register(ReqMsgTypeEnum msgType, Class messageBeanClass) {
        if (CollectionUtils.isEmpty(messageBeanMap)) {
            messageBeanMap = new ConcurrentHashMap<>(20);
        }
        messageBeanMap.put(msgType, messageBeanClass);
    }

    public Class getMessageBeanClass(ReqMsgTypeEnum reqMsgType) {
        if (Objects.isNull(messageBeanMap.get(reqMsgType))) {
            throw new RuntimeException("未注册本消息的对应处理器>>>" + reqMsgType.getDesc());
        }
        return messageBeanMap.get(reqMsgType);
    }
}
