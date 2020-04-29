package com.atom.atomwechat.controller;

import com.atom.atomwechat.helper.FansHelper;
import com.atom.atomwechat.model.fans.FansInfo;
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
    public List<FansInfo> fansInfoList() {
        List<FansInfo> fansInfos = new ArrayList<>();
        fansHelper.list().getData().getOpenid().forEach(openid -> {
            FansInfo info = fansHelper.info(openid);
            fansInfos.add(info);
        });
        return fansInfos;
    }
}
