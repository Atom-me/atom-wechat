package com.atom.wechat.model.req.normal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1351776360</CreateTime>
 * <MsgType><![CDATA[link]]></MsgType>
 * <Title><![CDATA[公众平台官网链接]]></Title>
 * <Description><![CDATA[公众平台官网链接]]></Description>
 * <Url><![CDATA[url]]></Url>
 * <MsgId>1234567890123456</MsgId>
 * </xml>
 * <p>
 * 接收链接消息
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqLinkMessage {
    /**
     * 接收方微信号
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;
    /**
     * 发送方微信号，若为普通用户，则是一个OpenID
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    /**
     * 消息创建时间
     */
    @XmlElement(name = "CreateTime")
    private String createTime;
    /**
     * 消息类型，链接为link
     */
    @XmlElement(name = "MsgType")
    private String msgType;
    /**
     * 消息标题
     */
    @XmlElement(name = "Title")
    private String title;
    /**
     * 消息描述
     */
    @XmlElement(name = "Description")
    private String description;
    /**
     * 消息链接
     */
    @XmlElement(name = "Url")
    private String url;
    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    private String msgId;

}
