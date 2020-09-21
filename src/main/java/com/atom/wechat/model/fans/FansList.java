package com.atom.wechat.model.fans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * {
 * "total":2,
 * "count":2,
 * "data":{
 * "openid":["OPENID1","OPENID2"]},
 * "next_openid":"NEXT_OPENID"
 * }
 * 帐号的关注者列表
 *
 * @author Atom
 */
@Data
public class FansList {
    /**
     * 关注该公众账号的总用户数
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
