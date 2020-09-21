package com.atom.wechat;

import com.atom.wechat.model.resp.Article;
import com.atom.wechat.model.resp.Item;
import com.atom.wechat.model.resp.MediaArticle;
import com.atom.wechat.model.resp.Text;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * @author atom
 */
@Slf4j
public class MyTest {
//    public static void main(String[] args) throws JAXBException {
//        createMediaArticleMsg();
//    }

    @Test
    public void createMediaArticleMsg() throws JAXBException {
        MediaArticle mediaArticle = new MediaArticle();
        mediaArticle.setFromUserName("lasdkjf");
        mediaArticle.setToUserName("23423");
        mediaArticle.setArticleCount(999);

        Article article = new Article();
        Item item = new Item();
        item.setDescription("desdlfkajsdf");
        item.setPicUrl("http://www.baidu.com");
        item.setTitle("titletitle");
        item.setUrl("www.google.com");

        article.setItem(Arrays.asList(item));
        mediaArticle.setArticles(Arrays.asList(article));
        transferObject2Xml(mediaArticle);
    }


    @Test
    public void createTextMsg() throws JAXBException {

        Text text = new Text();
        text.setContent("content");
        text.setCreateTime(System.currentTimeMillis() / 1000);
        text.setToUserName("sdlfkj");
        text.setFromUserName("dlksf32");

        transferObject2Xml(text);

    }

    private void transferObject2Xml(Object object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        //Required formatting??
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        //Print XML String to Console
        StringWriter sw = new StringWriter();

        //Write XML to StringWriter
        jaxbMarshaller.marshal(object, sw);

        //Verify XML Content
        String xmlContent = sw.toString();
        log.info("transfered objet [ {} ]  >>>  {}", object.getClass().getSimpleName(), xmlContent);
    }
}
