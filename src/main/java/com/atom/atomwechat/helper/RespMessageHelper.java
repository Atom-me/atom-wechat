package com.atom.atomwechat.helper;

import com.atom.atomwechat.enums.RespMsgTypeEnum;
import com.atom.atomwechat.model.req.normal.ReqTextMessage;
import com.atom.atomwechat.model.resp.Article;
import com.atom.atomwechat.model.resp.Item;
import com.atom.atomwechat.model.resp.MediaArticle;
import com.atom.atomwechat.model.resp.Text;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * @author atom
 */
@Component
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
        item.setDescription("图文消息描述啊啊啊");
        item.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/XdgiaNfVTSqmOvSu2OiaOTxJM9DEXZeiae7YpPteiaWEvlGjoNuZbicbeXF5U5eckyT7VtUYpVBAQGtNzrA2NGorlHQ/0");
        item.setTitle("图文消息标题零零落落");
        item.setUrl("http://www.baidu.com");

        article.setItem(Arrays.asList(item));
        mediaArticle.setArticles(Arrays.asList(article));
        mediaArticle.setArticleCount(article.getItem().size());

        return transferObjectToXml(mediaArticle);

    }

    public String buildTextMsg(ReqTextMessage reqTextMessage) {
        Text text = new Text();
        text.setContent("content");
        text.setCreateTime(System.currentTimeMillis() / 1000);
        text.setToUserName(reqTextMessage.getFromUserName());
        text.setFromUserName(reqTextMessage.getFromUserName());

        return transferObjectToXml(reqTextMessage);
    }

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
            String xmlContent = sw.toString();
            System.out.println(xmlContent);
            return xmlContent;
        } catch (Exception e) {
            throw new RuntimeException("object transfer to xml exception >>>>");
        }
    }

}
