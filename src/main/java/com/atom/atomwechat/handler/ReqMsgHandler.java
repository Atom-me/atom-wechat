package com.atom.atomwechat.handler;

import com.atom.atomwechat.enums.ReqMsgTypeEnum;

/**
 * @param <T>
 * @author Atom
 */
public interface ReqMsgHandler<T> {

    /**
     * 处理消息
     *
     * @param message
     * @return
     */
    String process(T message);

    /**
     * 路由消息处理器
     *
     * @return
     */
    ReqMsgTypeEnum getMsgType();
}
