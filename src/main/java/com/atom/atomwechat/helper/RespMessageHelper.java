package com.atom.atomwechat.helper;

import com.atom.atomwechat.enums.RespMsgTypeEnum;
import com.atom.atomwechat.model.req.normal.ReqTextMessage;
import com.atom.atomwechat.model.resp.Article;
import com.atom.atomwechat.model.resp.Item;
import com.atom.atomwechat.model.resp.MediaArticle;
import com.atom.atomwechat.model.resp.Text;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * @author atom
 */
@Component
@Slf4j
public class RespMessageHelper {

    /**
     * 构建图文消息
     *
     * @param reqTextMessage
     * @return
     */
    public String buildMediaArticleMsg(ReqTextMessage reqTextMessage) {
        MediaArticle mediaArticle = new MediaArticle();
        mediaArticle.setFromUserName(reqTextMessage.getToUserName());
        mediaArticle.setToUserName(reqTextMessage.getFromUserName());
        mediaArticle.setCreateTime(System.currentTimeMillis() / 1000);
        mediaArticle.setMsgType(RespMsgTypeEnum.NEWS.getType());

        Article article = new Article();
        Item item = new Item();
        item.setDescription("图文消息示例描述");
        item.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/XdgiaNfVTSqlU253cedtuGmFCqQhibwaXA1JfupiaQpOYsCpP4eibJD9MVR5PQElwoRdn6KHSia3r2VBSllibyibqkgBQ/0");
        item.setTitle("图文消息示例标题");
        item.setUrl("http://cn.bing.com/");

        article.setItem(Arrays.asList(item));
        mediaArticle.setArticles(Arrays.asList(article));
        mediaArticle.setArticleCount(article.getItem().size());

        return transferObjectToXml(mediaArticle);
    }

    /**
     * 构建文本消息
     *
     * @param reqTextMessage
     * @return
     */
    public String buildTextMsg(ReqTextMessage reqTextMessage) {
        Text text = new Text();
        text.setContent("content");
        text.setCreateTime(System.currentTimeMillis() / 1000);
        text.setToUserName(reqTextMessage.getFromUserName());
        text.setFromUserName(reqTextMessage.getFromUserName());

        return transferObjectToXml(reqTextMessage);
    }

    /**
     * transferObjectToXml
     *
     * @param object
     * @return
     */
    private String transferObjectToXml(Object object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //format
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //fragment remove xml header
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            //Print XML String to Console
            StringWriter sw = new StringWriter();
            //Write XML to StringWriter
            jaxbMarshaller.marshal(object, sw);
            return sw.toString();
        } catch (Exception e) {
            throw new RuntimeException("object transfer to xml exception.");
        }
    }

}
