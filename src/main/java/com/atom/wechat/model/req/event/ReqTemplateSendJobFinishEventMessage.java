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
 * <CreateTime>1589351919</CreateTime>
 * <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[TEMPLATESENDJOBFINISH]]></Event>
 * <MsgID>1338144854257483781</MsgID>
 * <Status><![CDATA[success]]></Status>
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
public class ReqTemplateSendJobFinishEventMessage {
    /**
     * 公众号微信号
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;
    /**
     * 接收模板消息的用户的openid
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private Long createTime;
    /**
     * 消息类型是事件 event
     */
    @XmlElement(name = "MsgType")
    private String msgType;
    /**
     * 事件为模板消息发送结束
     * {@link com.atom.wechat.enums.ReqMsgTypeEnum#EVENT_TEMPLATE_SEND_JOB_FINISH}
     */
    @XmlElement(name = "Event")
    private String event;
    /**
     * 事件KEY值，设置的跳转URL
     */
    @XmlElement(name = "MsgID")
    private Long msgId;

    /**
     * 发送状态为成功,失败，拒绝等等
     */
    @XmlElement(name = "Status")
    private String status;
}
