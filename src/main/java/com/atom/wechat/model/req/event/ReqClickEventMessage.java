package com.atom.wechat.model.req.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <xml><ToUserName><![CDATA[gh_7833711ad955]]></ToUserName>
 * <FromUserName><![CDATA[oSu9iw5mdd3btzDXXZwYRViaYttI]]></FromUserName>
 * <CreateTime>1584958741</CreateTime>
 * <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[CLICK]]></Event>
 * <EventKey><![CDATA[click_001]]></EventKey>
 * </xml>
 * <p>
 * 接收click事件推送
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqClickEventMessage {
    /**
     * 开发者微信号
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private Long createTime;
    /**
     * 消息类型，event
     */
    @XmlElement(name = "MsgType")
    private String msgType;
    /**
     * 事件类型，CLICK
     *
     * @see com.atom.wechat.enums.ReqMsgTypeEnum#EVENT_CLICK
     */
    @XmlElement(name = "Event")
    private String event;
    /**
     * 事件KEY值，设置的跳转URL
     */
    @XmlElement(name = "EventKey")
    private String eventKey;
}
