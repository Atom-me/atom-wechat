package com.atom.atomwechat.model.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Atom
 */
@Data
public class WeChatUserInfo {
    /**
     * {
     * "openid":" OPENID",
     * "nickname": NICKNAME,
     * "sex":"1",
     * "province":"PROVINCE",
     * "city":"CITY",
     * "country":"COUNTRY",
     * "headimgurl":       "http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
     * "privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
     * "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
     * }
     */

    /**
     * 用户的唯一标识
     */
    @JsonProperty(value = "openid")
    private String openId;
    /**
     * 用户昵称
     */
    @JsonProperty(value = "nickname")
    private String nickName;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private String sex;
    /**
     * 用户个人资料填写的省份
     */
    private String province;
    /**
     * 普通用户个人资料填写的城市
     */
    private String city;
    /**
     * 国家，如中国为CN
     */
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    @JsonProperty(value = "headimgurl")
    private String headImgUrl;
    /**
     * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    private List<String> privilege;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    @JsonProperty(value = "unionid")
    private String unionId;
}
