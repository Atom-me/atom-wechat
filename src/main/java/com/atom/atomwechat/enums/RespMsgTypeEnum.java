package com.atom.atomwechat.enums;

import lombok.Getter;

/**
 * @author atom
 */
public enum RespMsgTypeEnum {
    /**
     * 图文消息
     */
    NEWS("news", "图文消息"),
    TEXT("text", "文本消息"),


    ;

    @Getter
    private String type;
    @Getter
    private String desc;

    RespMsgTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
