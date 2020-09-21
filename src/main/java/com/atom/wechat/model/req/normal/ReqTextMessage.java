package com.atom.wechat.model.req.normal;

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
 * <CreateTime>1584883740</CreateTime>
 * <MsgType><![CDATA[text]]></MsgType>
 * <Content><![CDATA[哦哦哦]]></Content>
 * <MsgId>22690078695293750</MsgId>
 * </xml>
 *
 * <p>
 *
 * 接收文本消息
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqTextMessage {
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
     * 消息类型，文本为text
     */
    @XmlElement(name = "MsgType")
    private String msgType;
    /**
     * 文本消息内容
     */
    @XmlElement(name = "Content")
    private String content;
    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    private String msgId;

}


