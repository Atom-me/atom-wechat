package com.atom.wechat.controller;

import com.atom.wechat.helper.TemplateMsgHelper;
import com.atom.wechat.model.templatemessage.TemplateMsg;
import com.atom.wechat.model.templatemessage.TemplateMsgData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 发送模版消息
 *
 * @author Atom
 */
@RestController
@RequestMapping(value = "template")
public class TemplateMsgController {

    @Resource
    private TemplateMsgHelper templateMsgHelper;

    @GetMapping("send")
    public ResponseEntity<String> testSendTemplateMsg() throws JsonProcessingException {

        //构建模版消息对象
        TemplateMsg body = new TemplateMsg();
        body.setToUser("oSu9iw5mdd3btzDXXZwYRViaYttI");
        body.setTemplateId("KrLCU8BVLSg9KfsaepZlC-t-VXxO4XT57LKePDwKxuY");
        body.setUrl("https://cn.bing.com/");
        body.setTopColor("#FF0000");

        TemplateMsgData first = new TemplateMsgData();
        first.setFieldName("name");
        first.setFieldValue("Atom");

        TemplateMsgData company = new TemplateMsgData();
        company.setFieldName("company");
        company.setFieldValue("facebook");

        TemplateMsgData time = new TemplateMsgData();
        time.setFieldName("time");
        time.setFieldValue("2020-09-08");

        TemplateMsgData remark = new TemplateMsgData();
        remark.setFieldName("remark");
        remark.setFieldValue("记得带钱～");

        TemplateMsgData result = new TemplateMsgData();
        result.setFieldName("result");
        result.setFieldValue("通过了～");

        List<TemplateMsgData> templateMsgData = Arrays.asList(first, company, time, result, remark);

        body.buildTemplateMsgData(templateMsgData);
        String sendResult = templateMsgHelper.send(body);
        return ResponseEntity.ok(sendResult);
    }
}
