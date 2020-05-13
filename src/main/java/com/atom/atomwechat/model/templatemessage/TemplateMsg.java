package com.atom.atomwechat.model.templatemessage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 *<p>
 * {
 *     "touser": "OPENID",
 *     "template_id": "ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
 *     "url": "http://weixin.qq.com/download",
 *     "topcolor": "#FF0000",
 *     "data": {
 *         "User": {
 *             "value": "黄先生",
 *             "color": "#173177"
 *         },
 *         "Date": {
 *             "value": "06月07日 19时24分",
 *             "color": "#173177"
 *         },
 *         "CardNumber": {
 *             "value": "0426",
 *             "color": "#173177"
 *         },
 *         "Type": {
 *             "value": "消费",
 *             "color": "#173177"
 *         },
 *         "Money": {
 *             "value": "人民币260.00元",
 *             "color": "#173177"
 *         },
 *         "DeadTime": {
 *             "value": "06月07日19时24分",
 *             "color": "#173177"
 *         },
 *         "Left": {
 *             "value": "6504.09",
 *             "color": "#173177"
 *         }
 *     }
 * }
 * </p>
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
     */
    private String url;
    /**
     * 消息顶部的颜色
     */
    @JsonProperty(value = "topcolor")
    private String topColor;
    /**
     * 模板数据
     */
    private Map<String, Map<String, String>> data;

    public TemplateMsg buildTemplateMsgData(List<TemplateMsgData> dataList) {
        Map<String, Map<String, String>> data = Maps.newHashMapWithExpectedSize(dataList.size());
        if (!dataList.isEmpty()) {
            Map<String, String> dataItem;
            for (TemplateMsgData msgData : dataList) {
                dataItem = Maps.newHashMapWithExpectedSize(2);
                dataItem.put("value", msgData.getValue());
                dataItem.put("color", msgData.getColor());
                data.put(msgData.getName(), dataItem);
            }
        }
        this.setData(data);
        return this;
    }
}
