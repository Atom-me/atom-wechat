package com.atom.atomwechat.controller;

import com.atom.atomwechat.helper.FansHelper;
import com.atom.atomwechat.model.fans.FansList;
import com.atom.atomwechat.model.fans.Subscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 粉丝管理
 *
 * @author atom
 */
@RestController
@RequestMapping("/fans")
public class FansController {

    @Resource
    private FansHelper fansHelper;

    /**
     * 获取粉丝列表
     *
     * @return
     */
    @GetMapping("fansList")
    public FansList getFansList() {
        return fansHelper.list();
    }

    /**
     * 获取粉丝列表详情
     *
     * @return
     */
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
