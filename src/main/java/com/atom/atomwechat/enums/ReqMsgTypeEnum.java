package com.atom.atomwechat.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author atom
 */
public enum ReqMsgTypeEnum {
    /**
     * 文本消息
     */
    TEXT("text", "文本消息"),
    VOICE("voice", "语音消息"),
    IMAGE("image", "图片消息"),
    VIDEO("video", "视频消息"),
    SHORTVIDEO("shortvideo", "小视频消息"),
    LOCATION("location", "地理位置消息"),
    LINK("link", "链接消息"),
    EVENT("event", "事件通知"),


    ;

    /**
     * 请求消息类型
     */
    @Getter
    private String type;
    /**
     * 请求消息类型描述
     */
    @Getter
    private String desc;

    ReqMsgTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }


    public static ReqMsgTypeEnum lookup(String stringValue) {
        return Arrays.stream(ReqMsgTypeEnum.values())
                .filter(e -> e.getType().equals(stringValue))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("非法消息类型>>>" + stringValue));
    }
}
