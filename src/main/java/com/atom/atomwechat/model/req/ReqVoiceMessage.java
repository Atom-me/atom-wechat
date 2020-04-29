package com.atom.atomwechat.model.req;

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
 * <CreateTime>1584883788</CreateTime>
 * <MsgType><![CDATA[voice]]></MsgType>
 * <MediaId><![CDATA[082ew7SkSHpk8ABE_ciMufuuLY8wU84Jr22eO3Uv8BLipGNXKLSGjXhb7imI_W7m]]></MediaId>
 * <Format><![CDATA[amr]]></Format>
 * <MsgId>22690078057127244</MsgId>
 * <Recognition><![CDATA[]]></Recognition>
 * </xml>
 * <p>
 * <p>
 * 接收语音消息
 *
 * @author atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqVoiceMessage {
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
    private String createTime;
    /**
     * 语音为voice
     */
    @XmlElement(name = "MsgType")
    private String msgType;
    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;
    /**
     * 语音格式，如amr，speex等
     */
    @XmlElement(name = "Format")
    private String format;
    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    private String msgId;
    /**
     * 语音识别结果，UTF8编码
     * <p>
     * 开通语音识别后，用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，增加一个Recognition字段
     * （注：由于客户端缓存，开发者开启或者关闭语音识别功能，对新关注者立刻生效，对已关注用户需要24小时生效。开发者可以重新关注此帐号进行测试）
     */
    @XmlElement(name = "Recognition")
    private String recognition;
}
