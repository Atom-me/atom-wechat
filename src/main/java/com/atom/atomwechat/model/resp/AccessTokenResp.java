package com.atom.atomwechat.model.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * get access_token .
 *
 * @author atom
 */
@Data
public class AccessTokenResp implements Serializable {

    /**
     * 获取到的接口访问凭证.
     */
    @JsonProperty(value = "access_token")
    private String accessToken;
    /**
     * 凭证有效时间，单位：秒.
     */
    @JsonProperty(value = "expires_in")
    private Long expiresIn;
    @JsonProperty(value = "errcode")
    private Integer errCode;
    @JsonProperty(value = "errmsg")
    private String errMsg;
}
