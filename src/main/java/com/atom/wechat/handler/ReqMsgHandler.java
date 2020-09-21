package com.atom.wechat.handler;

import com.atom.wechat.enums.ReqMsgTypeEnum;

/**
 * 消息事件处理器
 *
 * @param <T> messageBean
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
