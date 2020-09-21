package com.atom.wechat.model.resp;

import lombok.Data;

import java.util.List;

/**
 * <Articles>
 * <item>
 * <Title><![CDATA[title1]]></Title>
 * <Description><![CDATA[description1]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl>
 * <Url><![CDATA[url]]></Url>
 * </item>
 * </Articles>
 * @author Atom
 */
@Data
public class Article {
    private List<Item> item;
}
