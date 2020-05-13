package com.atom.atomwechat.model.req.event;

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
 * <CreateTime>123456789</CreateTime>
 * <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[LOCATION]]></Event>
 * <Latitude>23.137466</Latitude>
 * <Longitude>113.352425</Longitude>
 * <Precision>119.385040</Precision>
 * </xml>
 * <p>
 * 接收 上报地理位置 事件推送
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqLocationEventMessage {
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
     * 事件类型，上报地理位置 事件
     * {@link com.atom.atomwechat.enums.ReqMsgTypeEnum#EVENT_LOCATION}
     */
    @XmlElement(name = "Event")
    private String event;
    /**
     * 地理位置纬度
     */
    @XmlElement(name = "Latitude")
    private Float latitude;
    /**
     * 地理位置经度
     */
    @XmlElement(name = "Longitude")
    private Float longitude;
    /**
     * 地理位置精度
     */
    @XmlElement(name = "Precision")
    private Float precision;


}
