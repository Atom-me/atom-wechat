package com.atom.atomwechat.controller;


import com.atom.atomwechat.config.MessageBeanContext;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.factory.ReqMsgHandlerFactory;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.utils.WeChatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.atom.atomwechat.constant.WeChatConstant.TOKEN;

/**
 * @author atom
 */
@RestController
@Slf4j
public class MessageAndEventController {

    @Resource
    private ReqMsgHandlerFactory reqMsgHandlerFactory;

    @Resource
    private MessageBeanContext messageBeanContext;

    /**
     * 验证消息的确来自微信服务器
     * 此接口配置在 微信公众平台后台接口地址处
     * http://atom.vipgz4.idcfengye.com/wechat/
     *
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return
     */
    @GetMapping("/")
    public String validate(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echostr) {
        return WeChatUtil.checkSignature(TOKEN, timestamp, nonce, signature) ? echostr : null;
    }

    /**
     * 处理消息和事件
     *
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     * @throws JAXBException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    @PostMapping("/")
    public String processRequest(HttpServletRequest request) throws IOException, DocumentException, JAXBException {
        // todo 解析消息和事件推送
        String requestParams = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        log.error(requestParams);
        ReqMsgTypeEnum reqMsgType = getMsgType(requestParams);
        ReqMsgHandler reqMsgHandler = reqMsgHandlerFactory.getReqMsgHandler(reqMsgType);
        return reqMsgHandler.process(getMsgBean(reqMsgType, requestParams));

        // todo 1 回复文本消息
        // todo 2 回复图片消息
        // todo 3 回复语音消息
        // todo 4 回复视频消息
        // todo 5 回复音乐消息

        // todo 查询菜单
        // todo 删除菜单
    }

    private <T> T getMsgBean(ReqMsgTypeEnum reqMsgType, String requestParams) throws JAXBException {
        Class messageBeanClass = messageBeanContext.getMessageBeanClass(reqMsgType);
        return (T) JAXBContext.newInstance(messageBeanClass)
                .createUnmarshaller()
                .unmarshal(new StringReader(requestParams));
    }

    private ReqMsgTypeEnum getMsgType(String requestParams) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(new ByteArrayInputStream(requestParams.getBytes(StandardCharsets.UTF_8)));
        Element root = doc.getRootElement();
        List<Element> elements = root.elements();
        for (Element element : elements) {
            if ("MsgType".equals(element.getName())) {
                return ReqMsgTypeEnum.lookup(element.getStringValue());
            }
        }
        return null;
    }

}
