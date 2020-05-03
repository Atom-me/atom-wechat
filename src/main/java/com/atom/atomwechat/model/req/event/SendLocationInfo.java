package com.atom.atomwechat.model.req.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

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
public class SendLocationInfo {
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
