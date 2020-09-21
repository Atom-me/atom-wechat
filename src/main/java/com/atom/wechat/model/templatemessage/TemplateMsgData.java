package com.atom.wechat.model.templatemessage;

import lombok.Data;

/**
 * @author Atom
 */
@Data
public class TemplateMsgData {
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 字段值
     */
    private String fieldValue;
    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;

}
