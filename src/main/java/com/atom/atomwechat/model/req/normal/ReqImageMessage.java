package com.atom.atomwechat.model.req.normal;

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
 * <CreateTime>1584941871</CreateTime>
 * <MsgType><![CDATA[image]]></MsgType>
 * <PicUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/XdgiaNfVTSqmOvSu2OiaOTxJM9DEXZeiae7YpPteiaWEvlGjoNuZbicbeXF5U5eckyT7VtUYpVBAQGtNzrA2NGorlHQ/0]]></PicUrl>
 * <MsgId>22690909294930738</MsgId>
 * <MediaId><![CDATA[qEaYLgsdBYuLGdnCussS_FaUE3jLhEVmUwmNYHstUY0076RZJ__SBg8T8cEFTDLA]]></MediaId>
 * </xml>
 *
 *
 * <p>
 * <p>
 * 接收图片消息
 *
 * @author Atom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqImageMessage {
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
     * 消息类型，图片为image
     */
    @XmlElement(name = "MsgType")
    private String msgType;
    /**
     * 图片链接（由系统生成）
     */
    @XmlElement(name = "PicUrl")
    private String picUrl;
    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    private String msgId;
    /**
     * 图片消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;
}
