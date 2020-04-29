package com.atom.atomwechat.model.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author atom
 */
@Data
public class AccessTokenResp implements Serializable {
    /**
     * 获取到的凭证
     */
    private String access_token;
    /**
     * 凭证有效时间，单位：秒
     */
    private Long expires_in;
    private Integer errcode;
    private String errmsg;
}
