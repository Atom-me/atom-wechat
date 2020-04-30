package com.atom.atomwechat.controller;

import com.atom.atomwechat.helper.FansHelper;
import com.atom.atomwechat.model.fans.Subscriber;
import com.atom.atomwechat.model.fans.FansList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author atom
 */
@RestController
@RequestMapping("/fans")
public class FansController {

    @Resource
    private FansHelper fansHelper;

    @GetMapping("fansList")
    public FansList getFansList() {
        FansList list = fansHelper.list();
        return list;
    }

    @GetMapping("fansinfos")
    public List<Subscriber> fansInfoList() {
        List<Subscriber> subscribers = new ArrayList<>();
        fansHelper.list().getData().getOpenId().forEach(openid -> {
            Subscriber info = fansHelper.info(openid);
            subscribers.add(info);
        });
        return subscribers;
    }
}
