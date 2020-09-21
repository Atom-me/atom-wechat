package com.atom.wechat.model.req.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 *
 * <xml><ToUserName><![CDATA[gh_7833711ad955]]></ToUserName>
 * <FromUserName><![CDATA[oSu9iw5mdd3btzDXXZwYRViaYttI]]></FromUserName>
 * <CreateTime>1588506858</CreateTime>
 * <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[location_select]]></Event>
 * <EventKey><![CDATA[click_003]]></EventKey>
 * <SendLocationInfo>
 * <Location_X><![CDATA[39.90373992919922]]></Location_X>
 * <Location_Y><![CDATA[116.3978271484375]]></Location_Y>
 * <Scale><![CDATA[15]]></Scale>
 * <Label><![CDATA[北京市东城区东长安街]]></Label>
 * <Poiname><![CDATA[天安门广场]]></Poiname>
 * </SendLocationInfo>
 * </xml>
 *
 * </p>
 * 接收 发送地理位置 事件推送
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqLocationSelectEventMessage {
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
     * 事件类型，
     *
     * @see com.atom.wechat.enums.ReqMsgTypeEnum#EVENT_LOCATION_SELECT
     */
    @XmlElement(name = "Event")
    private String event;
    /**
     * 事件KEY值，设置的跳转URL
     */
    @XmlElement(name = "EventKey")
    private String eventKey;
    /**
     * 发送地理位置详细信息
     */
    @XmlElement(name = "SendLocationInfo")
    private SendLocationInfo sendLocationInfo;


}

/**
 * <SendLocationInfo>
 * <Location_X><![CDATA[39.90373992919922]]></Location_X>
 * <Location_Y><![CDATA[116.3978271484375]]></Location_Y>
 * <Scale><![CDATA[15]]></Scale>
 * <Label><![CDATA[北京市东城区东长安街]]></Label>
 * <Poiname><![CDATA[天安门广场]]></Poiname>
 * </SendLocationInfo>
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
class SendLocationInfo {
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
     * POI是Point of Interest的缩写，是指兴趣点。
     * 每个POI至少包含以下4项基本信息：名称（Name）、类别（Type）、经度（longitude）、纬度（latitude），
     * 所以poiName指的是兴趣点名称，它可以是一栋房子、一个商铺、一个公厕或一个公交站等
     */
    @XmlElement(name = "Poiname")
    private String poiName;
}
