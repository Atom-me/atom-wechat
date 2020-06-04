package com.atom.atomwechat.enums;

import lombok.Getter;

/**
 * 返回消息类型
 *
 * @author Atom
 */
public enum RespMsgTypeEnum {
    /**
     * 图文消息
     */
    NEWS("news", "图文消息"),
    TEXT("text", "文本消息"),


    ;

    @Getter
    private final String type;
    @Getter
    private final String desc;

    RespMsgTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
