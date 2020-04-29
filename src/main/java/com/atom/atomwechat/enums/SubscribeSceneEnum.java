package com.atom.atomwechat.enums;

import lombok.Getter;

/**
 * 用户关注的渠道来源，
 * ADD_SCENE_SEARCH 公众号搜索，
 * ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，
 * ADD_SCENE_PROFILE_CARD 名片分享，
 * ADD_SCENE_QR_CODE 扫描二维码，
 * ADD_SCENE_PROFILE_LINK 图文页内名称点击，
 * ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，
 * ADD_SCENE_PAID 支付后关注，
 * ADD_SCENE_OTHERS 其他
 *
 * @author Atom
 */
public enum SubscribeSceneEnum {
    /**
     * 公众号搜索
     */
    ADD_SCENE_SEARCH("ADD_SCENE_SEARCH", "公众号搜索"),
    ADD_SCENE_ACCOUNT_MIGRATION("ADD_SCENE_ACCOUNT_MIGRATION", "公众号迁移"),
    ADD_SCENE_PROFILE_CARD("ADD_SCENE_PROFILE_CARD", "名片分享"),
    ADD_SCENE_QR_CODE("ADD_SCENE_QR_CODE", "扫描二维码"),
    ADD_SCENE_PROFILE_LINK("ADD_SCENE_PROFILE_LINK", "图文页内名称点击"),
    ADD_SCENE_PROFILE_ITEM("ADD_SCENE_PROFILE_ITEM", "图文页右上角菜单"),
    ADD_SCENE_PAID("ADD_SCENE_PAID", "支付后关注"),
    ADD_SCENE_OTHERS("ADD_SCENE_OTHERS", "其他"),


    ;

    @Getter
    private String code;
    @Getter
    private String desc;

    SubscribeSceneEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
