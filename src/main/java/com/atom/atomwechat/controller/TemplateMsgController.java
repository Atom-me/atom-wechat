package com.atom.atomwechat.controller;

import com.atom.atomwechat.helper.TemplateMsgHelper;
import com.atom.atomwechat.model.templatemessage.TemplateMsg;
import com.atom.atomwechat.model.templatemessage.TemplateMsgData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Atom
 */
@RestController
@RequestMapping(value = "template")
public class TemplateMsgController {

    @Resource
    private TemplateMsgHelper templateMsgHelper;

    @GetMapping("send")
    public ResponseEntity<String> testSendTemplateMsg() throws JsonProcessingException {

        TemplateMsg body = new TemplateMsg();
        body.setToUser("oSu9iw5mdd3btzDXXZwYRViaYttI");
        body.setTemplateId("KrLCU8BVLSg9KfsaepZlC-t-VXxO4XT57LKePDwKxuY");
        body.setUrl("https://cn.bing.com/");
        body.setTopColor("#FF0000");

        TemplateMsgData first = new TemplateMsgData();
        first.setName("name");
        first.setValue("Atom");

        TemplateMsgData company = new TemplateMsgData();
        company.setName("company");
        company.setValue("facebook");

        TemplateMsgData time = new TemplateMsgData();
        time.setName("time");
        time.setValue("2020-09-08");

        TemplateMsgData remark = new TemplateMsgData();
        remark.setName("remark");
        remark.setValue("记得带钱～");

        TemplateMsgData result = new TemplateMsgData();
        result.setName("result");
        result.setValue("通过了～");

        List<TemplateMsgData> templateMsgData = Arrays.asList(first, company, time, result, remark);

        body.buildTemplateMsgData(templateMsgData);
        String sendResult = templateMsgHelper.send(body);
        return ResponseEntity.ok(sendResult);
    }
}
