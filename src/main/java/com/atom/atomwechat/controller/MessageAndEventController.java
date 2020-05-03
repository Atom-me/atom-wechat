package com.atom.atomwechat.controller;


import com.atom.atomwechat.config.MessageBeanContext;
import com.atom.atomwechat.enums.ReqMsgTypeEnum;
import com.atom.atomwechat.factory.ReqMsgHandlerFactory;
import com.atom.atomwechat.handler.ReqMsgHandler;
import com.atom.atomwechat.model.BaseMsgBean;
import com.atom.atomwechat.utils.WeChatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.dom4j.DocumentException;
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
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import static com.atom.atomwechat.constant.WeChatConstant.TOKEN;
import static com.atom.atomwechat.enums.ReqMsgTypeEnum.EVENT;

/**
 * 消息和事件处理入口
 *
 * @author Atom
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
     * @param echoStr   随机字符串
     * @return
     */
    @GetMapping("/")
    public String validate(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echoStr) {
        return WeChatUtil.checkSignature(TOKEN, timestamp, nonce, signature) ? echoStr : null;
    }

    /**
     * 处理普通消息和事件推送
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
        String requestParams = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        log.info(requestParams);
        ReqMsgTypeEnum reqMsgType = parseMsgType(requestParams);
        ReqMsgHandler reqMsgHandler = reqMsgHandlerFactory.getReqMsgHandler(reqMsgType);
        return reqMsgHandler.process(getMsgBean(reqMsgType, requestParams));
    }

    /**
     * 获取消息对象
     *
     * @param reqMsgType
     * @param requestParams
     * @param <T>
     * @return
     * @throws JAXBException
     */
    private <T> T getMsgBean(ReqMsgTypeEnum reqMsgType, String requestParams) throws JAXBException {
        Class messageBeanClass = messageBeanContext.getMessageBeanClass(reqMsgType);
        return (T) JAXBContext.newInstance(messageBeanClass)
                .createUnmarshaller()
                .unmarshal(new StringReader(requestParams));
    }

    /**
     * 解析消息类型
     *
     * @param requestParams
     * @return
     */
    private ReqMsgTypeEnum parseMsgType(String requestParams) throws JAXBException {

        BaseMsgBean baseMsgBean = (BaseMsgBean) JAXBContext.newInstance(BaseMsgBean.class)
                .createUnmarshaller()
                .unmarshal(new StringReader(requestParams));

        String msgType = baseMsgBean.getMsgType();
        String event = baseMsgBean.getEvent();
        String eventKey = baseMsgBean.getEventKey();

        ReqMsgTypeEnum msgTypeEnum = ReqMsgTypeEnum.lookup(msgType);
        if (msgTypeEnum.equals(EVENT)) {
            msgTypeEnum = ReqMsgTypeEnum.matchEvent(event, eventKey);
        }
        return msgTypeEnum;
    }

}
