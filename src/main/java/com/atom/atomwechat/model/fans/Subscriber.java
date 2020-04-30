package com.atom.atomwechat.model.fans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * {
 * "subscribe": 1,
 * "openid": "o6_bmjrPTlm6_2sgVt7hMZOPfL2M",
 * "nickname": "Band",
 * "sex": 1,
 * "language": "zh_CN",
 * "city": "广州",
 * "province": "广东",
 * "country": "中国",
 * "headimgurl":"http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
 * "subscribe_time": 1382694957,
 * "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
 * "remark": "",
 * "groupid": 0,
 * "tagid_list":[128,2],
 * "subscribe_scene": "ADD_SCENE_QR_CODE",
 * "qr_scene": 98765,
 * "qr_scene_str": ""
 * }
 *
 * @author atom
 */
@Data
public class Subscriber {
    /**
     * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
     */
    private String subscribe;
    /**
     * 用户的标识，对当前公众号唯一
     */
    @JsonProperty(value = "openid")
    private String openId;
    /**
     * 用户的昵称
     */
    @JsonProperty(value = "nickname")
    private String nickName;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer sex;
    /**
     * 用户的语言，简体中文为zh_CN
     */
    private String language;
    /**
     * 用户所在城市
     */
    private String city;
    /**
     * 用户所在省份
     */
    private String province;
    /**
     * 用户所在省份
     */
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    @JsonProperty(value = "headimgurl")
    private String headImgUrl;
    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    @JsonProperty(value = "subscribe_time")
    private Long subscribeTime;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    @JsonProperty(value = "unionid")
    private String unionId;
    /**
     * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    private String remark;
    /**
     * 用户所在的分组ID（兼容旧的用户分组接口）
     */
    @JsonProperty(value = "groupid")
    private Integer groupId;
    /**
     * 用户被打上的标签ID列表
     */
    @JsonProperty(value = "tagid_list")
    private List<Integer> tagIdList;
    /**
     * @see com.atom.atomwechat.enums.SubscribeSceneEnum
     */
    @JsonProperty(value = "subscribe_scene")
    private String subscribeScene;
    /**
     * 二维码扫码场景（开发者自定义）
     */
    @JsonProperty(value = "qr_scene")
    private Integer qrScene;
    /**
     * 二维码扫码场景描述（开发者自定义）
     */
    @JsonProperty(value = "qu_scene_str")
    private String quSceneStr;

}
