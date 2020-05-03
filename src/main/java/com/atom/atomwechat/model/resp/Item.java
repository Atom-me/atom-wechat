package com.atom.atomwechat.model.resp;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <Articles>
 * <item>
 * <Title><![CDATA[title1]]></Title>
 * <Description><![CDATA[description1]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl>
 * <Url><![CDATA[url]]></Url>
 * </item>
 * </Articles>
 * 回复图文消息 中的 图文消息信息
 * @author Atom
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    /**
     * 图文消息标题
     */
    @XmlElement(name = "Title")
    private String title;
    /**
     * 图文消息描述
     */
    @XmlElement(name = "Description")
    private String description;
    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    @XmlElement(name = "PicUrl")
    private String picUrl;
    /**
     * 点击图文消息跳转链接
     */
    @XmlElement(name = "Url")
    private String url;
}
