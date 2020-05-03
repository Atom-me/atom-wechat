package com.atom.atomwechat.model.req.event;

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
 * <CreateTime>1588496881</CreateTime>
 * <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[VIEW]]></Event>
 * <EventKey><![CDATA[https://search.bilibili.com/all?keyword=java&from_source=nav_search_new]]></EventKey>
 * <MenuId>426127800</MenuId>
 * </xml>
 * <p>
 * 接收View事件推送
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqViewEventMessage {
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
     * 事件类型
     */
    @XmlElement(name = "Event")
    private String event;
    /**
     * 事件KEY值
     */
    @XmlElement(name = "EventKey")
    private String eventKey;

    /**
     * 菜单ID
     */
    @XmlElement(name = "MenuId")
    private Long menuId;
}
