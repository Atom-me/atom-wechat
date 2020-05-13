package com.atom.atomwechat.model.templatemessage;

import lombok.Data;

/**
 * @author Atom
 */
@Data
public class TemplateMsgData {
    private String name;
    private String value;
    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;

}
