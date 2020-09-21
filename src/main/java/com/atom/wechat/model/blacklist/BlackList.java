package com.atom.wechat.model.blacklist;

import com.atom.wechat.model.fans.OpenId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 黑名单列表
 *
 * @author Atom
 */
@Data
public class BlackList {
    /**
     * 被公众号拉入黑名单的总用户数
     */
    private Integer total;
    /**
     * 拉取的OPENID个数，最大值为10000
     */
    private Integer count;
    /**
     * 列表数据，OPENID的列表
     */
    private OpenId data;
    /**
     * 拉取列表的最后一个用户的OPENID
     */
    @JsonProperty(value = "next_openid")
    private String nextOpenId;
    @JsonProperty(value = "errcode")
    private Integer errCode;
    @JsonProperty(value = "errmsg")
    private String errMsg;
}
