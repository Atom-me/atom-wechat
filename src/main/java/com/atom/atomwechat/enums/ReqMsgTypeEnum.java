package com.atom.atomwechat.enums;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;

/**
 * 请求消息类型
 *
 * @author Atom
 */
public enum ReqMsgTypeEnum {
    /**
     * 文本消息
     */
    TEXT("text", "", "", "文本消息"),
    VOICE("voice", "", "", "语音消息"),
    IMAGE("image", "", "", "图片消息"),
    VIDEO("video", "", "", "视频消息"),
    SHORT_VIDEO("shortvideo", "", "", "小视频消息"),
    LOCATION("location", "", "", "地理位置消息"),
    LINK("link", "", "", "链接消息"),
    /*****************************************EVENT*****************************************/
    EVENT("event", "", "", "事件通知"),
    EVENT_SUBSCRIBE("event", "subscribe", "", "关注事件"),
    EVENT_UNSUBSCRIBE("event", "unsubscribe", "", "取消关注事件"),
    /**
     * 扫描带参数二维码事件
     * 用户未关注时，进行关注后的事件推送
     * EventKey	事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    EVENT_SUBSCRIBE_QRSCENE_("event", "subscribe", "qrscene_", " 用户未关注时，进行关注后的事件推送"),
    /**
     * 扫描带参数二维码事件
     * 用户已关注时的事件推送
     * EventKey	事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    EVENT_SCAN("event", "SCAN", "", "用户已关注时的事件推送"),
    EVENT_LOCATION("event", "LOCATION", "", "上报地理位置事件"),
    EVENT_LOCATION_SELECT("event", "location_select", "", "发送地理位置消息事件"),
    /**
     * 自定义菜单事件
     * 用户点击自定义菜单后，微信会把点击事件推送给开发者，请注意，点击菜单弹出子菜单，不会产生上报。
     * 点击菜单拉取消息时的事件推送
     */
    EVENT_CLICK("event", "CLICK", "", "点击菜单拉取消息时的事件推送"),
    /**
     * 点击菜单跳转链接时的事件推送
     */
    EVENT_VIEW("event", "VIEW", "", "点击菜单跳转链接时的事件推送"),
    /**
     * 在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知，发送到开发者在开发模式中填写的URL中。
     */
    EVENT_TEMPLATE_SEND_JOB_FINISH("event", "TEMPLATESENDJOBFINISH", "", "在模版消息发送任务完成后的事件推送"),


    ;

    /**
     * 请求消息类型
     */
    @Getter
    private String msgType;
    /**
     * 事件类型
     */
    @Getter
    private String event;
    /**
     * 事件KEY值
     */
    @Getter
    private String eventKey;
    /**
     * 请求消息类型描述
     */
    @Getter
    private String desc;


    ReqMsgTypeEnum(String msgType, String event, String eventKey, String desc) {
        this.msgType = msgType;
        this.event = event;
        this.eventKey = eventKey;
        this.desc = desc;
    }

    public static ReqMsgTypeEnum lookup(String reqMsgType) {
        return Arrays.stream(ReqMsgTypeEnum.values())
                .filter(e -> e.getMsgType().equals(reqMsgType))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("非法消息类型>>>" + reqMsgType));
    }

    private static Multimap<String, ReqMsgTypeEnum> eventMap = LinkedHashMultimap.create();

    static {
        Arrays.stream(ReqMsgTypeEnum.values())
                .filter(event -> event.name().startsWith("EVENT_"))
                .forEachOrdered(eventEnum -> eventMap.put(eventEnum.getEvent(), eventEnum));
    }

    public static ReqMsgTypeEnum matchEvent(String event, String eventKey) {

        Collection<ReqMsgTypeEnum> reqMsgTypeEnums = eventMap.get(event);

        if (reqMsgTypeEnums.size() == 1) {
            return reqMsgTypeEnums.iterator().next();
        }

        for (ReqMsgTypeEnum reqMsgTypeEnum : reqMsgTypeEnums) {
            if (StringUtils.isNotBlank(reqMsgTypeEnum.getEventKey()) && eventKey.startsWith(reqMsgTypeEnum.getEventKey())) {
                return reqMsgTypeEnum;
            } else if (StringUtils.isBlank(eventKey)) {
                return reqMsgTypeEnum;
            }
        }

        throw new IllegalStateException("非法事件消息类型");
    }


}
