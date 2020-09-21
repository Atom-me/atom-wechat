package com.atom.wechat.model.templatemessage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 模版消息对象
 * <p>
 * {
 * "touser": "OPENID",
 * "template_id": "ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
 * "url": "http://weixin.qq.com/download",
 * "topcolor": "#FF0000",
 * "data": {
 * "User": {
 * "value": "黄先生",
 * "color": "#173177"
 * },
 * "Date": {
 * "value": "06月07日 19时24分",
 * "color": "#173177"
 * },
 * "CardNumber": {
 * "value": "0426",
 * "color": "#173177"
 * },
 * "Type": {
 * "value": "消费",
 * "color": "#173177"
 * },
 * "Money": {
 * "value": "人民币260.00元",
 * "color": "#173177"
 * },
 * "DeadTime": {
 * "value": "06月07日19时24分",
 * "color": "#173177"
 * },
 * "Left": {
 * "value": "6504.09",
 * "color": "#173177"
 * }
 * }
 * }
 * </p>
 *
 * @author Atom
 */
@Data
public class TemplateMsg {
    /**
     * 接收者openid
     */
    @JsonProperty(value = "touser")
    private String toUser;
    /**
     * 模板ID
     */
    @JsonProperty(value = "template_id")
    private String templateId;
    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     * url和miniprogram都是非必填字段，若都不传则模板无跳转；若都传，会优先跳转至小程序。
     * 开发者可根据实际需要选择其中一种跳转方式即可。当用户的微信客户端版本不支持跳小程序时，将会跳转至url。
     */
    private String url;
    /**
     * 消息顶部的颜色
     */
    @JsonProperty(value = "topcolor")
    private String topColor;
    /**
     * 模板数据 体
     */
    private Map<String, Map<String, String>> data;

    /**
     * 构建模版消息 data 体
     *
     * @param dataList
     * @return
     */
    public TemplateMsg buildTemplateMsgData(List<TemplateMsgData> dataList) {
        Map<String, Map<String, String>> data = Maps.newHashMapWithExpectedSize(dataList.size());
        if (!dataList.isEmpty()) {
            Map<String, String> dataItem;
            for (TemplateMsgData msgData : dataList) {
                dataItem = Maps.newHashMapWithExpectedSize(2);
                dataItem.put("value", msgData.getFieldValue());
                dataItem.put("color", msgData.getColor());
                data.put(msgData.getFieldName(), dataItem);
            }
        }
        this.setData(data);
        return this;
    }
}
