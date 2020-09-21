package com.atom.wechat.controller;

import com.atom.wechat.helper.FansHelper;
import com.atom.wechat.model.fans.FansList;
import com.atom.wechat.model.fans.Subscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 粉丝管理
 *
 * @author Atom
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
        return fansHelper.list()
                .getData()
                .getOpenId()
                .stream()
                .map(openId -> fansHelper.info(openId))
                .collect(Collectors.toList());
    }
}
