package com.atom.atomwechat.model.resp;

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
 * @author atom
 */
@Data
public class Article {
    private List<Item> item;
}
