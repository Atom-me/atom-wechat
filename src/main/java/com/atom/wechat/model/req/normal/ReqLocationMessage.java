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
 * <MsgType><![CDATA[location]]></MsgType>
 * <Location_X>23.134521</Location_X>
 * <Location_Y>113.358803</Location_Y>
 * <Scale>20</Scale>
 * <Label><![CDATA[位置信息]]></Label>
 * <MsgId>1234567890123456</MsgId>
 * </xml>
 * <p>
 * 接收地理位置信息
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqLocationMessage {
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
     * 消息类型，地理位置为location
     */
    @XmlElement(name = "MsgType")
    private String msgType;
    /**
     * 地理位置维度
     */
    @XmlElement(name = "Location_X")
    private String locationX;
    /**
     * 地理位置经度
     */
    @XmlElement(name = "Location_Y")
    private String locationY;
    /**
     * 地图缩放大小
     */
    @XmlElement(name = "Scale")
    private String scale;
    /**
     * 地理位置信息
     */
    @XmlElement(name = "Label")
    private String label;
    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    private String msgId;

}


